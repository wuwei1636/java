package com.li.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

//        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/demo");   // 转发的请求路径
//        requestDispatcher.forward(req,resp);  // 用forword实现请求转发

        context.getRequestDispatcher("/demo").forward(req,resp);

        System.out.println("进入了ServlDemo04");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
