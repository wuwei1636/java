package com.li.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest1 {

    @RequestMapping("m1/h1")
    public String test(HttpServletRequest req, HttpServletResponse resp){

        HttpSession session = req.getSession();
        System.out.println(session.getId());

        return "test";
    }
}
