package com.li.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取要下载文件的路径
//        String realPath = this.getServletContext().getRealPath("/1.jpg");
        String realPath = "E:\\project\\demo\\javaweb-02-servlet\\response\\src\\main\\resources\\1.jpg";
        System.out.println("下载文件的路径"+realPath);
        // 下载的文件名
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
        // 设置想办法让浏览器能够支持我们需要的东西
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
//        中文名字使用URLEcoder.encode编码，否则有可能乱码
//        resp.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(filename,"UTF-8");
        // 获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        // 创建缓存区
        int len = 0;
        byte[] buffer = new byte[1024];
        // 获取OUTputStream对象
        ServletOutputStream out = resp.getOutputStream();
        // 使FileOutStream流写入buffer缓冲区,使用OutputStream将缓冲区中的数据输出到客户端
        while((len = in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
