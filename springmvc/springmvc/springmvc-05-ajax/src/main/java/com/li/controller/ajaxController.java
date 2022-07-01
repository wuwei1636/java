package com.li.controller;

import com.li.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ajaxController {

    @RequestMapping("/t1")
    public String test(){
        return "test";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse resp) throws IOException {
        System.out.println("接收的"+name);
        if("likunsong".equals(name)){
            resp.getWriter().print("true");
        }else {
            resp.getWriter().print("false");
        }

    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList = new ArrayList<User>();
        userList.add(new User("likunsong",17,"男"));
        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd){
        String msg = "";
        if(name != null){
            if("admin".equals((name))){
                msg = "ok";
            }else {
                msg = "用户名有误";
            }
        }

        if(pwd != null){
            if("123456".equals((pwd))){
                msg = "ok";
            }else {
                msg = "用户名有误";
            }
        }


        return msg;
    }

}

