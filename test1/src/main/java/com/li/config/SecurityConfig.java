package com.li.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    //  加密
    @Bean
    public PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    // 认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 登录
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/hello").permitAll()
                .and().csrf().disable();

        // 设置访问权限
        http.authorizeRequests()
                .antMatchers("/hello1").hasRole("vip1")
                .antMatchers("/","/user/login","/user/register","/register").permitAll();
                        //.antMatchers("/hello1").hasRole("ROLE_vip");
        http.authorizeRequests()
                .anyRequest().authenticated();

        // 没有权限访问跳转的界面
        http.exceptionHandling().accessDeniedPage("/uncheck");

    }

    // 忽略拦截
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/**/*.js","/**/*.css","/**/*.jpg");
    }
}
