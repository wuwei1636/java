package com.li.config;

import com.li.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 这个也会被Spring容器中托管，因为它本身就是一个 @Component , @COnfiguration 代表这是一个配置类
// 就像我们之前的beans.xml
@Configuration
@ComponentScan("com.li.pojo")
@Import(config2.class)
public class myconfig {

    // 注册一个bean，就相当于我们之前写的bean标签
    // 这个方法的名字 == bean标签中的 id
    // 这个方法的返回值 == bean标签中的class
    @Bean
    public User getUser(){
        return new User();
    }

}
