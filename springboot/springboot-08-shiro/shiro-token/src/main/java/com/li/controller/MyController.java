package com.li.controller;

import com.li.config.TokenUtil;
import com.li.pojo.User;
import com.li.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MyController {


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

    @RequestMapping("/login")
    public String login(String username, String password, Model model, HttpServletResponse response, HttpServletRequest request){




        // 获取当前的用户
        Subject subject = SecurityUtils.getSubject();

        // 封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try{
            subject.login(token); // 执行登录的方法，如果没有异常就ok

            return "index";
        }catch (UnknownAccountException e){ // 用户名不存在
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){ //密码不存在
            model.addAttribute("msg","密码错误");
            return "login";
        }


    }


    @RequestMapping("/noauth")
    public String Unauthorized(){
        return "401";
    }

}
