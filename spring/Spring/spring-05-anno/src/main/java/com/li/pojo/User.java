package com.li.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 等价与 <bean id= "user" class = "com.li.pojo.User"/>
// @Component 组件
@Component
@Scope("singleton")
public class User {

    public String name ;

    @Value("likun")
    public void setName(String name) {
        this.name = name;
    }
}
