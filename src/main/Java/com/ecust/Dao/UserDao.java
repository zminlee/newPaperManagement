package com.ecust.Dao;

import com.ecust.Entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by DoveXL on 2017/10/26.
 */
public interface UserDao {
    public User getUser(String UserID);
}
