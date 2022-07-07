package com.example.springboot05mybatis.service;

import com.example.springboot05mybatis.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> userList();

    User queryUserId(int id);

    int update(User user);

    int addUser(User user);

    int delete(int id);

}
