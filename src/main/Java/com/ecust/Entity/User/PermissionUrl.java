package com.ecust.Entity.User;

public class PermissionUrl {
    private String PermissionID;
    private String PermissionName;
    private String Url;
    private int ParentPID;

    public String getPermissionID() {
        return PermissionID;
    }

    public void setPermissionID(String permissionID) {
        PermissionID = permissionID;
    }

    public String getPermissionName() { return PermissionName; }

    public void setPermissionName(String permissionName) {
        PermissionName = permissionName;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public int getParentPID() {
        return ParentPID;
    }

    public void setParentPID(int parentPID) { ParentPID = parentPID; }


}
