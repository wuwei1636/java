package com.li.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    // 初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset = utf-8");

        filterChain.doFilter(servletRequest,servletResponse) ; // 让我们的请求继续走，否则我们的程序到这里就被拦截

    }
    // 销毁，服务器关闭的时候，会销毁
    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
