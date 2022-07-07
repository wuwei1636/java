package com.li.swagger.controller;


import com.li.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "hello的controller类")
@RestController
public class helloController {

    @GetMapping(value = "/hello")
    public String Hello(){
        return "hello";
    }


    @PostMapping("/user")
    public User user(){
        return new User();
    }


    // Opera接口，不是放在类上，是接口上
    @ApiOperation("hello控制类")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello2"+username;
    }

    @ApiOperation("post控制类")
    @PostMapping("/hello3")
    public String hello3(@ApiParam("用户名") String username){
        return "hello2"+username;
    }

}
