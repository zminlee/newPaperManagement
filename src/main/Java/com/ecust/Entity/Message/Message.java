package com.ecust.Entity.Message;

/**
 * Created by DoveXL on 2017/10/28.
 */
public class Message {
    private int id;
    private String SendUserID;
    private String ReceiveUserID;
    private String MessageContents;
    private String MessageTime;
    private Integer Status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSendUserID() {
        return SendUserID;
    }

    public void setSendUserID(String sendUserID) {
        SendUserID = sendUserID;
    }

    public String getReceiveUserID() {
        return ReceiveUserID;
    }

    public void setReceiveUserID(String receiveUserID) {
        ReceiveUserID = receiveUserID;
    }

    public void setMessageContents(String messageContents) {
        MessageContents = messageContents;
    }

    public String getMessageContents() {
        return MessageContents;
    }

    public void setMessageTime(String messageTime) {
        MessageTime = messageTime;
    }

    public String getMessageTime() {
        return MessageTime;
    }


    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }
}
