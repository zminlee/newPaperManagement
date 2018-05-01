package com.ecust.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ecust.Entity.User.User;
import com.ecust.Entity.User.UserRole;
import com.ecust.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
@RequestMapping(value = "/login/**")
public class LoginController {
    @Autowired
    private UserService userService;

    //private List<UserRole> UserList=new ArrayList<UserRole>();

    @RequestMapping(value="/login/index.do")
    public String User_Index(HttpSession httpSession)
    {
        UserRole SessionUser = (UserRole) httpSession.getAttribute("LoginUser");
        if (SessionUser!=null)
        {
            String RoleID =SessionUser.getRoleID();
            if(RoleID.equals("Administrator")) {
                return "/AdministratorHome";
            }else if (RoleID.equals("NormalUser"))
            {
                return "/NormalUserHome";
            }else
            {
                return "/LoginFailure";
            }
        }else
        {
            return "/index";

        }
    }

    @RequestMapping(value="/login/UserLogin",method = RequestMethod.POST)
    public String User_Login(@RequestParam String UserID, @RequestParam String UserPwd , @RequestParam String RoleID, HttpServletRequest httpServletRequest,HttpSession httpSession)
    {
        System.out.println(UserID);
        System.out.println(UserPwd);
        System.out.println(RoleID);
        UserRole userRole  = userService.getUserInfo(UserID,UserPwd,RoleID);
        if (userRole!=null)
        {
            httpSession.setAttribute("LoginUser",userRole);
            httpSession.setAttribute("UserID",UserID);
            httpSession.setAttribute("RoleID",RoleID);
            System.out.println(httpSession.getId());
            if(RoleID.equals("Administrator")) {
                return "/AdministratorHome";
            }else if (RoleID.equals("NormalUser"))
            {
                return "/NormalUserHome";
            }else
            {
                return "/LoginFailure";
            }
        }
        else
        {
            return "/LoginFailure";
        }
        }


    @RequestMapping(value="/login/LoginOut",method = RequestMethod.GET)
    public String UserLoginOut(HttpSession Session)
    {
        //UserRole SessionUser = (UserRole) httpSession.getAttribute("LoginUser");
        System.out.println(Session.getId());
        Session.removeAttribute(Session.getId());
        Session.invalidate();
        return "/index";
    }


    @RequestMapping(value = "/login/index")
    public String index(){
        System.out.println("index");
        return "/index";
    }



//    @RequestMapping(value = "/index")
//    public String UserRegister(@RequestParam String UserID, @RequestParam String Name,@RequestParam String UserPwd ,  @RequestParam String TelPhone, HttpServletRequest httpServletRequest,HttpSession httpSession) {
//        boolean flag = isExistUserName(UserID);
//        if(UserID.equals("zmin")) {
//            System.out.println("returntoregister");
//            return "/register";
//        }
//        else return "/index";
//    }


//    public boolean isExistUserName(String userName){
//        boolean flag=false;
//        UserDaoT userDaoT=new UserDaoT();
//        User user=userDaoT.queryByName(userName);
//        System.out.println(user.getUserName());
//        if(user.getUserName()!=null)flag=true;
//        return flag;
//    }


}
