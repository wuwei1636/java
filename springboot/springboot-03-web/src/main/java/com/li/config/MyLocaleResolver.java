package com.li.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求中的参数链接
        String l = httpServletRequest.getParameter("l");

        Locale locale = Locale.getDefault(); // 如果没有就使用默认的

        // 如果请求的链接携带了地区化的参数
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            // 国家 地区
            locale = new Locale(split[0], split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
