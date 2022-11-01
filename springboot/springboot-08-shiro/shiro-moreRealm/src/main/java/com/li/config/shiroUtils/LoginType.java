package com.li.config.shiroUtils;

// 登录类型的枚举
public enum LoginType {
    USER("User"), ADMIN("Admin");

    private String type;    //定义的是登陆的类型

    private LoginType(String type){
        this.type=type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}


