package com.ecust.Service;


import com.ecust.Entity.User.User;
import com.ecust.Entity.User.UserRole;

import java.util.List;

public interface UserService {
    public UserRole getUserInfo(String UserID,String UserPwd,String RoleID);

    public List<UserRole> getUserInfo();



    public String getUserUnique(String UserID);

    public String RegisterUser(String UserID,String UserName,String Name,String UserPwd,String TelPhone,String CreatePersonID,String CreateTime,String RoleID);




}
