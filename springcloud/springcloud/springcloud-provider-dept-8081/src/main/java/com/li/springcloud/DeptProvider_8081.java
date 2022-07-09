package com.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 在服务启动后，自动注册到eureka中
public class DeptProvider_8081 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8081.class,args);
    }

}
