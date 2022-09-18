package com.li.service.impl;

import com.li.mapper.UserMapper;
import com.li.pojo.User;
import com.li.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
