package com.li.controller;

import com.li.config.shiroUtils.CustomToken;
import com.li.config.shiroUtils.LoginType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    private static final String LOGIN_TYPE_user= LoginType.USER.toString();
    private static final String LOGIN_TYPE_admin= LoginType.ADMIN.toString();

    @RequestMapping({"/index","/"})
    public String toIndex(Model model){
        model.addAttribute("msg","helloworld");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        // 获取当前的用户
        Subject subject = SecurityUtils.getSubject();

        // 封装用户的登陆数据
        CustomToken userToken = new CustomToken(username, password,LOGIN_TYPE_user);


        try{
            subject.login(userToken); // 执行登录的方法，如果没有异常就ok
            return "index";
        }catch (UnknownAccountException e){ // 用户名不存在
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){ //密码不存在
            model.addAttribute("msg","密码错误");
            return "login";
        }


    }

    @RequestMapping("/login2")
    public String login2(String username, String password, Model model){

        // 封装用户的登陆数据
        CustomToken adminToken = new CustomToken(username, password,LOGIN_TYPE_admin);
        // 获取当前的用户
        Subject subject = SecurityUtils.getSubject();

        try{
            subject.login(adminToken); // 执行登录的方法，如果没有异常就ok
            return "index";
        }catch (UnknownAccountException e){ // 用户名不存在
            model.addAttribute("msg2","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){ //密码不存在
            model.addAttribute("msg2","密码错误");
            return "login";
        }


    }


    @RequestMapping("/noauth")
    public String Unauthorized(){
        return "401";
    }

}
