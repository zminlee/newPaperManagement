package com.ecust.Entity;

/**
 * Created by DoveXL on 2017/10/26.
 */
public class User {
    private String UserID;
    private String UserName;
    private String UserPwd;
    private String Name;
    private String TelPhone;


    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public String getUserName() {
        return UserName;
    }

    public String getTelPhone() {
        return TelPhone;
    }

    public String getUserPwd() {
        return UserPwd;
    }

    public void setTelPhone(String telPhone) {
        TelPhone = telPhone;
    }


    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setUserPwd(String userPwd) {
        UserPwd = userPwd;
    }
}
