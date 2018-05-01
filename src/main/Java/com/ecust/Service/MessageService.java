package com.ecust.Service;

import com.ecust.Entity.Message.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MessageService {

    public List<Message> getMessage(String UserID,int Status,String Type);

    public void AddMessage(String SendUserID, String ReceiveUserID, String MessageContents, int Status, String MessageTime);

    public void DeleteMessage(String SendUserID,String ReceiveUserID,String MessageID);

    public void UpdateMessage(String SendUserID,String ReceiveUserID,String MessageID,int Status);
}
