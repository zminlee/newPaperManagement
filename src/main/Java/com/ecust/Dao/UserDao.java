package com.ecust.Dao;

import com.ecust.Entity.User.User;
import com.ecust.Entity.User.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
public interface UserDao {



    public void RegisterUser(@Param("UserID") String UserID,@Param("UserName") String UserName,@Param("Name")String Name,@Param("UserPwd") String UserPwd,@Param("TelPhone")String TelPhone,@Param("CreatePersonID")String CreatePersonID,@Param("CreateTime")String CreateTime);

    public int UserNumber(String UserID);

}



//    public void DeleteUser(@Param("UserID") String UsserID, @Param("UserName") String UserName,@Param("UserPwd") String UserPwd,@Param("TelPhone") String TelPhone);
//
//    public void UpdateUser(@Param("UserID") String UsserID, @Param("UserName") String UserName,@Param("UserPwd") String UserPwd,@Param("TelPhone") String TelPhone);
//



