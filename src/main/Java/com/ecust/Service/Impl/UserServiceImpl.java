//package com.ecust.Service.Impl;
//
//import com.ecust.Dao.UserDao;
//import com.ecust.Dao.UserRoleDao;
//import com.ecust.Entity.User.User;
//import com.ecust.Entity.User.UserRole;
//import com.ecust.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * Created by DoveXL on 2017/10/26.
// */
//@Service
//@Transactional(rollbackFor = Exception.class)
//public class UserServiceImpl implements UserService{
//
//    @Autowired(required = false)
//    private UserDao userDao;
//
//
//    @Autowired
//    private UserRoleDao userRoleDao;
//
//    public User getUser(String UserID)
//    {
//        return userDao.getUser(UserID);
//    }
//
//    public UserRole getUserInfo(String UserID,String UserPwd,String RoleID)
//    {
//            return userRoleDao.getUserInfo(UserID,UserPwd,RoleID);
//    }
//
//
//    public List<UserRole> getUserInfo()
//    {
//        return userRoleDao.getAllUserInfo();
//    }
//}
package com.ecust.Service.Impl;

import com.ecust.Dao.UserDao;
import com.ecust.Dao.UserRoleDao;
import com.ecust.Entity.User.User;
import com.ecust.Entity.User.UserRole;
import com.ecust.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    public UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;

    public UserRole getUserInfo(String UserID,String UserPwd,String RoleID)
    {
        return userRoleDao.getUserInfo(UserID,UserPwd,RoleID);
    }


    public List<UserRole> getUserInfo()
    {
        return userRoleDao.getAllUserInfo();
    }


    public String RegisterUser(String UserID,String UserName,String Name,String UserPwd,String TelPhone,String CreatePersonID,String CreateTime,String RoleID)
    {
        userDao.RegisterUser(UserID,UserName,Name,UserPwd,TelPhone,CreatePersonID,CreateTime);
        userRoleDao.AddUserRole(UserID,RoleID);
        return "true";
    }


    public String getUserUnique(String UserID)
    {
        int Number = userDao.UserNumber(UserID);
        if(Number == 1)
        {
            return "true";
        }else if (Number ==0)
        {
            return "false";
        }
        else
        {
            return "error";
        }
    }





}
