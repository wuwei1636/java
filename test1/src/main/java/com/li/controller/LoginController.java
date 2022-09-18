package com.li.controller;

import com.li.pojo.User;
import com.li.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg1","输出");
        return "view/hello";
    }

    @RequestMapping({"/login","/"})
    public String login(){
        return "view/login";
    }


    @RequestMapping("/user/register")
    public String register(User user, String pwd2, Model model){
        System.out.println(pwd2);
        if(user.getPassword().equals(pwd2)){
            userService.addUser(user);
            System.out.println("注册成功");
        }
        else model.addAttribute("msg","请输入完整的账号密码");
        return "redirect:view/login";
    }

    @RequestMapping("/hello1")
    public String hello1(){
        return "view/hello1";
    }

    // 没有权限访问
    @RequestMapping("/uncheck")
    public String uncheck(){
        return "view/403";
    }

}
