package com.li.service;

import com.li.dao.UserDao;

public class UserServiceImpl implements UserService {

    private UserDao Userdao;
    public void setUserdao(UserDao userdao) {
        Userdao = userdao;
    }
    public void getUser() {
        Userdao.getUser();
    }
}
