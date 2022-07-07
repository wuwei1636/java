package com.li.service;

import com.li.pojo.User;

import java.util.List;

public interface UserService {


    //查询所有用户
    List<User> userList();

    //根据用户名查询
    User queryUserByName(String name,String password);

    User queryUserName(String name);

}
