package com.li.service;

import com.li.pojo.User;

public interface UserService {

    User getUserByName(String username);

    void addUser(User user);
}
