package com.example.springboot05mybatis.controller;

import com.example.springboot05mybatis.Mapper.UserMapper;
import com.example.springboot05mybatis.pojo.User;
import com.example.springboot05mybatis.service.UserService;
import com.example.springboot05mybatis.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public List<User> userList(){
        System.out.println("1111");
        List<User> users = userService.userList();
        for(User user : users){
            System.out.println(user);
        }
        return users;

    }



}
