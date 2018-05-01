package com.ecust.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ecust.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping(value = "/Register/**")
public class RegisterController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/Register/ToRegister" ,method = RequestMethod.GET)
    public String RegisterUser(){
        //System.out.println("index");
        return "Register";
    }



    @RequestMapping(value = "/Register/CheckRegisterUser" ,method = RequestMethod.POST)
    @ResponseBody
    public String CheckRegisterUser(@RequestBody String UserInfo) {
        JSONObject jsonObject = JSON.parseObject(UserInfo);
        String UserID = jsonObject.getString("UserID");

        String Status = userService.getUserUnique(UserID);
        return Status;
    }

    @RequestMapping(value = "/Register/RegisterUser" ,method = RequestMethod.POST)
    public String RegisterUser(@RequestBody String UserInfo)
    {
        JSONObject jsonObject = JSON.parseObject(UserInfo);
        String UserID = jsonObject.getString("UserID");
        String UserName = jsonObject.getString("UserName");
        String Name = jsonObject.getString("Name");
        String UserPwd = jsonObject.getString("UserPwd");
        String TelPhone = jsonObject.getString("TelPhone");
        String CreatePersonID = UserID;
        Date date = new Date();
        String RoleID = "NormalUser";
        String CreateTime = date.toString();
        String Status = userService.RegisterUser(UserID,UserName,Name,UserPwd,TelPhone,UserID,CreateTime,RoleID);
        if (Status.equals("false"))
        {
            return "/RegisterFailure";
        }
        else
        {
            return "/RegisterSuccess";

        }
    }


}
