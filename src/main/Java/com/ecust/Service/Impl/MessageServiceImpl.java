package com.ecust.Service.Impl;

import com.ecust.Dao.MessageDao;
import com.ecust.Entity.Message.Message;
import com.ecust.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    public List<Message> getMessage(String UserID, int Status, String Type) {
        if(Type.equals("Receive"))
        {
            return  messageDao.getReceiveMessage(UserID,Status);
        }else if (Type.equals("Send"))
        {
            return messageDao.getSendMessage(UserID);
        }else {
            return null;
        }
    }


    public void AddMessage(String SendUserID, String ReceiveUserID, String MessageContents, int Status, String MessageTime)
    {
        messageDao.AddMessage(SendUserID,ReceiveUserID,MessageContents,Status,MessageTime);

    }

    public void DeleteMessage(String SendUserID,String ReceiveUserID,String MessageID)
    {
        messageDao.DeleteMessage(SendUserID,ReceiveUserID,MessageID);
    }


    public void UpdateMessage(String SendUserID,String ReceiveUserID,String MessageID,int Status)
    {
        messageDao.UpdateMessage(SendUserID,ReceiveUserID,MessageID,Status);
    }
}
