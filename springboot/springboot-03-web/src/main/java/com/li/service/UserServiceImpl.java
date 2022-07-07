package com.li.service;

import com.li.Mapper.UserMapper;
import com.li.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> userList() {
        return userMapper.userList();
    }

    @Override
    public User queryUserByName(String name,String password) {
        return userMapper.queryUserByName(name,password);
    }

    @Override
    public User queryUserName(String name) {
        return userMapper.queryUserName(name);
    }
}
