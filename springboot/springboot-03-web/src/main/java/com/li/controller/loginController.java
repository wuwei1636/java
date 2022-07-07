package com.li.controller;

import com.li.pojo.User;
import com.li.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class loginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "index";
    }

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session){

        List<User> userList = userService.userList();

        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            model.addAttribute("msg","请输入用户名或密码");
            return "index";
        } else if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            if(userService.queryUserByName(username,password) == null) {
                model.addAttribute("msg","用户名或密码错误");
                return "index";
            }else{
                //    告诉用户登录失败
                System.out.println("++++++++++");
                session.setAttribute("LoginUser",username);
                return "redirect:/main.html";
            }
        }
        System.out.println("11111111111");
        return "index";

    }

    @RequestMapping("/user/loginout")
    public String Loginout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }

}
