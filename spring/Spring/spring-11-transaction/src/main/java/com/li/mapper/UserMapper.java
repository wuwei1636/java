package com.li.mapper;

import com.li.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> selectUser();

    public int addUser(User user);

    public int del(int id);
}
