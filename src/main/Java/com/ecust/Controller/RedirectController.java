package com.ecust.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by DoveXL on 2017/10/28.
 */
@Controller
@RequestMapping(value = "/Redirect/**")
public class RedirectController {

    @RequestMapping(value="ContactUser",method = RequestMethod.GET)
    public String ContactUser(HttpSession httpSession)
    {
        System.out.println(httpSession.getAttribute("UserID"));
        return "/ContactUser";
    }

    @RequestMapping(value="Home",method = RequestMethod.GET)
    public String Index(HttpSession httpSession)
    {
        System.out.println(httpSession.getAttribute("UserID"));
        String RoleID = httpSession.getAttribute("RoleID").toString();
        if(RoleID.equals("Administrator"))
        {
            return "/AdministratorHome";
        }else if (RoleID.equals("NormalUser"))
        {
            return "/NormalUserHome";
        }else
        {
            return "/index";
        }

    }


    @RequestMapping(value = "updatePaper")
    public String update(){
        System.out.println("update");
        return "Update";
    }

    @RequestMapping(value = "queryPaper")
    public String query(){
        System.out.println("query");
        return "Query";
    }

    @RequestMapping(value = "deletePaper")
    public String delete() {
        System.out.println("delete");
        return "Delete";
    }

    @RequestMapping(value = "addPaper")
    public String Add(){
        System.out.println("Add");
        return "/Add";
    }
}
