package com.ecust.Dao;

import com.ecust.Entity.User.PermissionUrl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionurlDao {
    public List<PermissionUrl> getPermissionUrl(@Param("PermissionID") String PermissionID, @Param("PermissionName") String PermissionName,@Param("Url") String Url,@Param("ParentPID") String ParentPID);

    public void AddPermissionUrl(@Param("PermissionID") String PermissionID, @Param("PermissionName") String PermissionName,@Param("Url") String Url,@Param("ParentPID") String ParentPID);

    public void DeletePermissionUrl(@Param("PermissionID") String PermissionID, @Param("PermissionName") String PermissionName,@Param("Url") String Url,@Param("ParentPID") String ParentPID);

    public void UpdatePermissionUrl(@Param("PermissionID") String PermissionID, @Param("PermissionName") String PermissionName,@Param("Url") String Url,@Param("ParentPID") String ParentPID);
}
