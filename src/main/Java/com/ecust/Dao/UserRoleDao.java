package com.ecust.Dao;

import com.ecust.Entity.User.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRoleDao {
    public UserRole getUserInfo(@Param("UserID") String UserID, @Param("UserPwd") String UserPwd, @Param("RoleID") String RoleID);

    public List<UserRole> getAllUserInfo();


    public void AddUserRole(@Param("UserID") String UserID, @Param("RoleID") String RoleID);
}
