package com.example.springboot05mybatis.service;

import com.example.springboot05mybatis.Mapper.UserMapper;
import com.example.springboot05mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> userList() {
        System.out.println("userservice");
        System.out.println(userMapper.userList());
        return userMapper.userList();
    }

    @Override
    public User queryUserId(int id) {
        return userMapper.queryUserId(id);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int delete(int id) {
        return userMapper.delete(id);
    }
}
