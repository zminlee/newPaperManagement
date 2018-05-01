package com.ecust.ApplicationClass.Message;


import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ecust.Entity.Message.Message;
import com.ecust.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by DoveXL on 2017/10/28.
 */
public class  SpringWebSocketHandler extends TextWebSocketHandler {

    private static final Map<String,WebSocketSession> users;//这个会出现性能问题，最好用Map来存储，key用userid
    //private static Logger logger =Logger.(SpringWebSocketHandler.class);
    static {
        users = new HashMap<String, WebSocketSession>();
    }
    @Autowired
    private MessageService messageService;

    public SpringWebSocketHandler() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 连接成功时候，会触发页面上onopen方法
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
        String UserID = session.getAttributes().get("WEBSOCKET_USERNAME").toString();

        System.out.println("connect to the websocket success......系统数量:" + users.size());
        System.out.println("connect to the websocket success......当前用户:" + UserID);
        if(users.get(UserID)!=null)
        {
            if (users.get(UserID).getId()!=session.getId())
            {
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("TypeFlag",-2);
                map.put("Status","LoginOut");
                this.SendTextMessage(users.get(UserID),new TextMessage(JSON.toJSONString(map)));
            }
        }
        while (true)
        {
            if (users.get(UserID)==null)
            {
                users.put(UserID,session);
                break;
            }
        }
        List<Message> messageList = messageService.getMessage(UserID,0,"Receive");
        String UnReadNumber = String.valueOf(messageList.size());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("TypeFlag",-1);
        map.put("Status","ReadNumber");
        map.put("UnReadNumber",UnReadNumber);
        this.SendTextMessage(session,new TextMessage(JSON.toJSONString(map)));
        System.out.println("connect to the websocket success......当前sessionID:" + session.getId());
        System.out.println("connect to the websocket success......当前数量:" + users.size());
    }


    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        //logger.debug("websocket connection closed......");
        String username= (String) session.getAttributes().get("WEBSOCKET_USERNAME");
        System.out.println("用户"+username+"已退出！");
        users.remove(username);
        System.out.println("剩余在线用户"+users.size());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println(message.getPayload().toString());
        //JSONObject jsonObject = JSON.parse(message.getPayload().toString());
        int TypeFlag = JSON.parseObject(message.getPayload().toString()).getIntValue("TypeFlag");
        System.out.println(TypeFlag);
        String UserID;
        Map<String,Object> ReplyMessage = new HashMap<String, Object>();
        try {
            if (TypeFlag == 1) {
                ReplyMessage.put("TypeFlag",1);
                ReplyMessage.put("UserFlag",0);
                UserID = this.SaveTextMessage(message);
                String SendUserID = JSON.parseObject(message.getPayload().toString()).getString("SendUserID");
                WebSocketSession socketSession1 = users.get(SendUserID);
                ReplyMessage.put("Status","Success");
                this.SendTextMessage(socketSession1, new TextMessage(JSON.toJSONString(ReplyMessage)));
                List<Message> messageList = messageService.getMessage(UserID, 0, "Receive");
                String UnReadNumber = String.valueOf(messageList.size());
                ReplyMessage.put("UnReadNumber",UnReadNumber);
                ReplyMessage.put("UserFlag",1);
                if (users.get(UserID) != null) {
                    WebSocketSession socketSession = users.get(UserID);
                    this.SendTextMessage(socketSession, new TextMessage(JSON.toJSONString(ReplyMessage)));
                }
                //此处为增加消息记录
            } else if (TypeFlag == 2) {
                //此处为删除消息记录
                ReplyMessage.put("TypeFlag",2);
                String MessageID = JSON.parseObject(message.getPayload().toString()).getString("MessageID");
                ReplyMessage.put("MessageID",MessageID);
                UserID = this.DeleteTextMessage(message);
                //String SendUserID = JSON.parseObject(message.getPayload().toString()).getString("ReceiveUserID");
                //WebSocketSession socketSession1 = users.get(SendUserID);
                ReplyMessage.put("Status","Success");
                List<Message> messageList = messageService.getMessage(UserID, 0, "Receive");
                String UnReadNumber = String.valueOf(messageList.size());
                ReplyMessage.put("UnReadNumber",UnReadNumber);
                if (users.get(UserID) != null) {
                    WebSocketSession socketSession = users.get(UserID);
                    this.SendTextMessage(socketSession, new TextMessage(JSON.toJSONString(ReplyMessage)));
                }
                //this.SendTextMessage(socketSession1, new TextMessage(JSON.toJSONString(ReplyMessage)));


            } else if (TypeFlag == 3) {
                //此处为设置已读未读;
                ReplyMessage.put("TypeFlag",3);
                String MessageID = JSON.parseObject(message.getPayload().toString()).getString("MessageID");
                ReplyMessage.put("MessageID",MessageID);
                UserID = this.UpdateTextMessage(message);
               // String SendUserID = JSON.parseObject(message.getPayload().toString()).getString("ReceiveUserID");
               // WebSocketSession socketSession1 = users.get(SendUserID);
                ReplyMessage.put("Status","Success");
                List<Message> messageList = messageService.getMessage(UserID, 0, "Receive");
                String UnReadNumber = String.valueOf(messageList.size());
                ReplyMessage.put("UnReadNumber",UnReadNumber);
                if (users.get(UserID) != null) {
                    WebSocketSession socketSession = users.get(UserID);
                    this.SendTextMessage(socketSession, new TextMessage(JSON.toJSONString(ReplyMessage)));
                }
            } else {
                UserID = "Unknown";
            }
        }catch (Exception e)
        {
            if (TypeFlag == 1) {
                UserID = JSON.parseObject(message.getPayload().toString()).getString("SendUserID");
                WebSocketSession socketSession1 = users.get(UserID);
                ReplyMessage.put("Status","Failure");
                this.SendTextMessage(socketSession1, new TextMessage(JSON.toJSONString(ReplyMessage)));
            }else
            {
                UserID = JSON.parseObject(message.getPayload().toString()).getString("ReceiveUserID");
                WebSocketSession socketSession1 = users.get(UserID);
                ReplyMessage.put("Status","Failure");
                this.SendTextMessage(socketSession1, new TextMessage(JSON.toJSONString(ReplyMessage)));
            }
        }
        super.handleTextMessage(session, message);

    }

    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        String UserID = session.getAttributes().get("WEBSOCKET_USERNAME").toString();
        if(session.isOpen()){session.close();}

        //logger.debug("websocket connection closed......");
        users.remove(UserID);
    }

    public boolean supportsPartialMessages() {
        return false;
    }



    private void SendTextMessage(WebSocketSession session,TextMessage textMessage) {
        try {
            if (session.isOpen()) {
                session.sendMessage(textMessage);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String  SaveTextMessage(TextMessage message)
    {
        String Message = message.getPayload().toString();
        JSONObject jsonObject =JSONObject.parseObject(Message);
        String SendUserID = jsonObject.getString("SendUserID");
        String ReceiveUserID = jsonObject.getString("ReceiveUserID");
        String MessageContents = jsonObject.getString("MessageContents");
        int Status = jsonObject.getInteger("Status");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        messageService.AddMessage(SendUserID,ReceiveUserID,MessageContents,Status,df.format(date));

        return ReceiveUserID;
    }

    private String DeleteTextMessage(TextMessage message)
    {
        String Message = message.getPayload().toString();
        JSONObject jsonObject =JSONObject.parseObject(Message);
        String MessageID = jsonObject.getString("MessageID");
        String SendUserID = jsonObject.getString("SendUserID");
        String ReceiveUserID = jsonObject.getString("ReceiveUserID");
        messageService.DeleteMessage(SendUserID,ReceiveUserID,MessageID);
        return ReceiveUserID;
    }


    private String UpdateTextMessage(TextMessage message)
    {
        String Message = message.getPayload().toString();
        JSONObject jsonObject =JSONObject.parseObject(Message);
        String MessageID = jsonObject.getString("MessageID");
        String SendUserID = jsonObject.getString("SendUserID");
        String ReceiveUserID = jsonObject.getString("ReceiveUserID");
        int Status = jsonObject.getIntValue("Status");
        messageService.UpdateMessage(SendUserID,ReceiveUserID,MessageID,Status);
        return ReceiveUserID;
    }
}
