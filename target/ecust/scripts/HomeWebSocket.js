/**
 * Created by DoveXL on 2017/10/28.
 */
var websocket = null;
$(document).ready(function () {

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

        }else if(Data.TypeFlag==-1) {
            $("#UnReadNumber").html(Data.UnReadNumber);
            $("#UnReadTumber").html(Data.UnReadNumber);
        }else if(Data.TypeFlag==1)
        {
            if (Data.Status=="Success" && Data.UserFlag==1)
            {
                $("#UnReadNumber").html(Data.UnReadNumber);
                $("#UnReadTumber").html(Data.UnReadNumber);
            }
        }

    };
    console.log(websocket);
});

function CloseWebSocket() {
    if(websocket!=null)
    {
        websocket.close();
    }
    return true
}