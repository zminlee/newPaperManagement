/**
 * Created by DoveXL on 2017/10/28.
 */
var websocket = null;
$(document).ready(function () {
    CreateWebSocket();
    var RoleID = $("#RoleIDSpan").html().trim();
    var UserID = $("#UserIDSpan").html().trim();
    var UserSelect = $("#UserSelect");
    if(RoleID=="Administrator")
    {
        $("#UserManagement").css("display",'block');
        $("#collapseTwo").find("ul").find('li:first').css("color",'red');
        $("#collapseTwo").show();
        $("#collapseFour").hide();
        $("#collapseOne").hide();
        $("#collapseThree").hide();
    }else
    {
        $("#UserManagement").css("display",'none');
        $("#collapseTwo").find("ul").find('li:first').css("color",'red');
        $("#collapseTwo").show();
        $("#collapseFour").hide();
        $("#collapseOne").hide();
        $("#collapseThree").hide();
    }
});


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

        }
        if(Data.TypeFlag==-1)
        {
            $("#UnReadNumber").html(Data.UnReadNumber);

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