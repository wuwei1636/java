package com.li.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// 保存用户上一次访问的时间
public class cookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 服务器告诉你，你来的时间，把这个时间封装成一个信件，你下次带着来，我就知道你来了

        // 解决中文乱码
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        // cookie , 服务器端从客户端获取
        Cookie[] cookies = req.getCookies(); // 这里返回数组，说明cookie可能存在多个

        // 判断cookie是否存在
        if(cookies!= null){
            // 如果存在
            out.write("上一次访问的时间");

            for(int i = 0;i < cookies.length;i ++){
                Cookie cookie = cookies[i];
                // 获取cookie的名字
                if(cookie.getName().equals("Lasttime")){
                    // 获取cookie的值
                    long lasttime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lasttime);
                    out.write(date.toLocaleString());
                }

            }
        }else{
            out.print("这是您第一次访问");
        }

        // 服务器给客户端响应一个cookie
        Cookie cookie = new Cookie("Lasttime", System.currentTimeMillis()+"");

        // 设置cookie有效期时间
        cookie.setMaxAge(24*60*60);

        resp.addCookie(cookie);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
