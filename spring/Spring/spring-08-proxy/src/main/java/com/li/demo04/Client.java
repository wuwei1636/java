package com.li.demo04;

import com.li.demo02.UserServiceImpl;
import com.li.demo02.UserServide;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();

        ProxyInvacationHandler handler = new ProxyInvacationHandler();

        handler.setTarget(userService); // 设置要代理的对象

        // 动态生成代理类
        UserServide proxy = (UserServide) handler.getProxy();

        proxy.add();

    }
}
