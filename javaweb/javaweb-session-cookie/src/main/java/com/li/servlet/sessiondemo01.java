package com.li.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class sessiondemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        // 得到session
        HttpSession session = req.getSession();


        // 给session存东西
        session.setAttribute("name","李坤松");

        // 获取session的ID
        String id = session.getId();

        // 判断session新创建
        if(session.isNew()){
            resp.getWriter().write("session已经创建成功，ID"+id);
        }else{
            resp.getWriter().write("session以及在服务器中存在了，ID"+id);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
