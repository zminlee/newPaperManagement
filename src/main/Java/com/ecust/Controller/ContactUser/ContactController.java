package com.ecust.Controller.ContactUser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ecust.Service.MessageService;
import com.ecust.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/Contact/**")
public class ContactController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;


    @RequestMapping(value="getContactUser",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public  String getContactUser()
    {
        return JSON.toJSONString(userService.getUserInfo());
    }


    @RequestMapping(value="getMessageContents",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public  String getMessageContents(@RequestBody  String jsonString)
    {
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String UserID = jsonObject.getString("ReceiveUserID");
        int Status = jsonObject.getInteger("Status");
        String Type = jsonObject.getString("Type");
        return JSON.toJSONString(messageService.getMessage(UserID,Status,Type));
    }

}
