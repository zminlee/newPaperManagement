
var websocket = null;
var SQLErrorFlag=null;
$(document).ready(function () {
    CreateWebSocket();
    var RoleID = $("#RoleIDSpan").html().trim();
    var UserID = $("#UserIDSpan").html().trim();
    var UserSelect = $("#UserSelect");
    if(RoleID=="Administrator")
    {
        $("#UserManagement").css("display",'block');
        $("#collapseFour").find("ul").find('li:first').css("color",'red');
        $("#collapseFour").show();
        $("#collapseTwo").hide();
        $("#collapseOne").hide();
        $("#collapseThree").hide();
    }else
    {
        $("#UserManagement").css("display",'none');
        $("#collapseFour").find("ul").find('li:first').css("color",'red');
        $("#collapseFour").show();
        $("#collapseTwo").hide();
        $("#collapseOne").hide();
        $("#collapseThree").hide();
    }
    getUser(UserID,RoleID,UserSelect)
});


function getUser(UserID,RoleID,Select) {

    $.ajax({
        url:'/PaperManagement/Contact/getContactUser',
        type:'post',
        success:function (data) {
            $(Select).empty();
            $("<option></option>").val("PleaseChoose")
                .text("请选择")
                .appendTo($(Select));
            var data =eval(data);
            for (var  i =0;i<data.length;i++)
            {
                if(data[i].userID!=UserID)
                {
                    $("<option></option>").val(data[i].userID)
                        .text(data[i].userName)
                        .appendTo($(Select));
                }
            }
        }

    });
}





function CreateWebSocket() {
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/PaperManagement/Message/SocketServer");
    }
    else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://localhost:8080/PaperManagement/Message/SocketServer");
    }
    else {
        websocket = new SockJS("ws://localhost:8080/PaperManagement/Message/SocketServerJS");
    }
    websocket.onopen = function (p1) { console.log(p1) };

    websocket.onmessage = function (event) {
        var Data = $.parseJSON(event.data);
        if(Data.TypeFlag==-2)
        {
            websocket.close();
            alert("另有用户登录，您已经被强制退出！");

        }else if(Data.TypeFlag==-1)
        {
            $("#UnReadNumber").html(Data.UnReadNumber);

        }else if(Data.TypeFlag==1)
        {
            if(Data.Status=="Success" && Data.UserFlag==0)
            {
                alert("消息发送成功!");
                //$("#MessageInput").clear();
                $("#MessageCommit").addClass("disabled","disabled");
                $("#MessageCommit").attr("disabled","disabled");

            }else if (Data.Status=="Success" && Data.UserFlag==1)
            {
                $("#UnReadNumber").html(Data.UnReadNumber);
            }
            else if (Data.Status=="Failure")
            {
                alert("消息发送失败");
            }else
            {
            }

        }else if(Data.TypeFlag==3)
        {
            if(Data.Status=="Success")
            {
                $("#UnReadNumber").html(Data.UnReadNumber);
                var ButtonID = "SetRead"+Data.MessageID;
                $("#"+ButtonID).html("已读");
                $("#"+ButtonID).addClass("disabled","disabled");
                $("#"+ButtonID).attr("disabled","disabled");
            }
            if(Data.Status=="Failure")
            {
                alert("设置已读失败!");
            }

        }else if(Data.TypeFlag==2)
        {
            if(Data.Status=="Success")
            {
                $("#UnReadNumber").html(Data.UnReadNumber);
                var ButtonID = "Delete"+Data.MessageID;
                $("#"+ButtonID).addClass("disabled","disabled");
                $("#"+ButtonID).attr("disabled","disabled");
            }
            if(Data.Status=="Failure")
            {
                alert("删除失败!");
            }
        }else {
            console.log(websocket);
        }
    };
}

function CloseWebSocket() {
    if(websocket!=null)
    {
        websocket.close();
    }
    return true
}

function ChangeFocus() {
    $("#MessageCommit").removeClass("disabled","disabled");
    $("#MessageCommit").removeAttr("disabled","disabled");
}


function SaveTextMessage() {
    var SendUserID = $("#UserIDSpan").html().trim();
    var MessageContents = $("#MessageInput").val().trim();
    MessageContents.replace(/\r\n/g, '<br/>').replace(/\n/g, '<br/>').replace(/\s/g, ' ');
    var ReceiveUserID = $("#UserSelect").val().trim();
    var Status = 0;
    if(ReceiveUserID=="PleaseChoose")
    {
        alert("收件人不允许为空");
        return false;
    }
    if(MessageContents.length==0)
    {
        alert("内容不允许为空");
        return false;
    }
        var JsonString = {
            "TypeFlag": 1,
            "SendUserID": SendUserID,
            "ReceiveUserID": ReceiveUserID,
            "MessageContents": MessageContents,
            "Status": Status
        };
        websocket.send(JSON.stringify(JsonString));

        return true
}


function SetReadMessage(node) {
    var ReceiveUserID = $("#UserIDSpan").html().trim();
    var SendUserID = $(node).parent().parent().find("div:first").find("label:first").html().trim();
    var MessageID = $(node).parent().prev().prev().find("label:first").next().next().html().trim();
    if(ReceiveUserID.length!=0 && SendUserID.length!=0&&MessageID.length!=0)
    {
        var JsonString = {
            "TypeFlag": 3,
            "SendUserID": SendUserID,
            "ReceiveUserID": ReceiveUserID,
            "MessageID":MessageID,
            "Status":1
        };

        websocket.send(JSON.stringify(JsonString));
        return true

    }else
    {
        return false;
    }

}

function DeleteMessage(node) {
    var ReceiveUserID = $("#UserIDSpan").html().trim();
    var SendUserID = $(node).parent().parent().find("div:first").find("label:first").html().trim();
    var MessageID = $(node).parent().prev().prev().find("label:first").next().next().html().trim();
    if (ReceiveUserID.length != 0 && SendUserID.length != 0 && MessageID.length != 0) {
        var JsonString = {
            "TypeFlag": 2,
            "SendUserID": SendUserID,
            "ReceiveUserID": ReceiveUserID,
            "MessageID": MessageID
        };

        websocket.send(JSON.stringify(JsonString));
        $(node).html("已删除");
        $(node).addClass("disabled", "disabled");
        $(node).attr("disabled", "disabled");
        var Node = $(node).prev();
        $(Node).attr("disabled", "disabled");
        $(Node).addClass("disabled", "disabled");
        return true

    } else {
        return false;
    }
}


function RefreshMessage() {
    var Status = 0;
    var DivID = $("#MessageContents");
    var Type = "Receive";
    $("#MessageContents").empty();
    ShowReadMessage(DivID,Status,Type);
}

function ShowReadMessage(DiVID,Status,Type) {
    var ReceiveUserID = $("#UserIDSpan").html().trim();

    if (ReceiveUserID == null)
    {
        alert("登录异常，请检查");
    }else
    {
        $.ajax(
            {
                url:"/PaperManagement/Contact/getMessageContents",
                type:"post",
                dataType:"json",
                contentType:"application/json;chartset=utf-8",
                data:JSON.stringify({"ReceiveUserID":ReceiveUserID,"Status":Status,"Type":Type}),
                success:function (Message) {
                    var Message=eval(Message);
                    if (Message.length>0)
                    {
                        $("#MessageContentsBody").css("display",'block');
                    }
                    for(var i=0;i<Message.length;i++)
                    {
                        var divUserNode = "<div><label class='control-label' style='font-family: 楷体;font-size: 18px'>"+Message[i].sendUserID+"</label><label class='control-label' style='margin-left:2%;font-family: Times New Roman;font-size: 14px;color: lightgray'>"+Message[i].messageTime+"</label><label style='display: none'>"+Message[i].id+"</label></div>";
                        var divContentsInfo = "<div>"+Message[i].messageContents+"</div>";
                        var  ButtonID = "SetRead"+Message[i].id;
                        var  ButtonDelID = "Delete"+Message[i].id;
                        var divButtonInfo = "<div><button type='button' class='btn btn-danger btn-sm' style='float: right;margin-left: 2%;' onclick='DeleteMessage(this)' id="+ButtonDelID+">删除</button><button type='button' class='btn btn-default btn-sm' style='float: right;' onclick='SetReadMessage(this)' id="+ButtonID+">设置已读</button></div>";
                        var divHrInfo = "<div style='height: 5%;margin-top: 5%'><hr style='color: gray;' /></div>";

                        $(divUserNode).appendTo(DiVID);
                        $(divContentsInfo).appendTo(DiVID);
                        $(divButtonInfo).appendTo(DiVID);
                        if(i<Message.length-1) {
                            $(divHrInfo).appendTo(DiVID);
                        }
                    }
                }
            }
        )
    }
}