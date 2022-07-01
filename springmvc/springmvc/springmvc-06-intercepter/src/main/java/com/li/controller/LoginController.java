package com.li.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/gologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        // 把用户的信息存在session中
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "main";
    }

    @RequestMapping("/goout")
    public String goout(HttpSession session){
        session.removeAttribute("username");
        session.removeAttribute("password");

        return "main";
    }

}
