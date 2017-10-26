package com.ecust.Service.Impl;

import com.ecust.Dao.UserDao;
import com.ecust.Entity.User;
import com.ecust.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by DoveXL on 2017/10/26.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public User getUser(String UserID)
    {
        return userDao.getUser(UserID);
    }
}
