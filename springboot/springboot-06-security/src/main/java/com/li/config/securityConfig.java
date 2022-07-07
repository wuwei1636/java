package com.li.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {

    // 授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限默认到登陆界面,需要开启登陆的界面
        http.formLogin().loginPage("/toLogin");

        http.csrf().disable(); //关闭csrf
    //    注销
        http.logout().logoutSuccessUrl("/");

        // 记住我功能 cookie 默认保存两周
        http.rememberMe().rememberMeParameter("remember");
    }

    // 认证规则
    // 密码编码 ： 密码没有被加密
    // 在springsecurity 中增加了很多的加密文件
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 这些数据应该从数据库中读取

        auth.inMemoryAuthentication().passwordEncoder(new Pbkdf2PasswordEncoder())
                .withUser("likunsong").password(new Pbkdf2PasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new Pbkdf2PasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new Pbkdf2PasswordEncoder().encode("123456")).roles("vip1");

    }
}
