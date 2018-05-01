package com.ecust.Dao;

import com.ecust.Entity.Message.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DoveXL on 2017/10/28.
 */
@Repository
public interface MessageDao {

    public List<Message> getReceiveMessage(@Param("ReceiveUserID") String ReceiveUserID, @Param("Status") int Status);

    public List<Message> getSendMessage(@Param("SendUserID") String SendUserID);

    public void AddMessage(@Param("SendUserID") String SendUserID,@Param("ReceiveUserID") String ReceiveUserID,@Param("MessageContents") String MessageContents,@Param("Status") int Status,@Param("MessageTime") String MessageTime);

    public void DeleteMessage(@Param("SendUserID") String SendUserID,@Param("ReceiveUserID") String ReceiveUserID,@Param("MessageID") String MessageID);

    public void UpdateMessage(@Param("SendUserID") String SendUserID,@Param("ReceiveUserID") String ReceiveUserID,@Param("MessageID") String MessageID,@Param("Status") int Status);

}
