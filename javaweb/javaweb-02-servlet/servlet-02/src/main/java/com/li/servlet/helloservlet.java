package com.li.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class helloservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        this.getInitParameter()   初始化参数
//        this.getServletConfig()   servlet配置原理
//        this.getServletInfo()     servlet上下文

        ServletContext context = this.getServletContext();

        String username = "likunsong";
        context.setAttribute("username",username);   // 将一个数据保存在ServletContext中，名字为username，值为 username

        System.out.println("hello");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
