package com.li.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // ShiroFilterFactoryBean  shiro过滤的对象:3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        // 添加shiro的内置过滤器
        /*
            anno: 无需认证就能访问
            authc：必须认证了才能访问
            user： 必须拥有”记住我功能“  才能使用
            perms： 拥有对某个资源的权限才能访问
            role： 拥有某个角色权限才能访问
         */

        // 拦截
        Map<String, String> filterMap = new LinkedHashMap<>();

        // 授权,正常情况下，没有授权会跳转到未授权界面
        filterMap.put("/user/add","perms[user:add]");

        //filterMap.put("/user/add","authc");
        //filterMap.put("/user/update","authc");
        filterMap.put("/user/*","authc");

        bean.setFilterChainDefinitionMap(filterMap);

        // 设置登录的请求
        bean.setLoginUrl("/toLogin");
        // 未授权界面
        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }


    // DefaultWebSecurityManager:2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联 UserRealm,通过spring来进行关联，如上面的参数 @Qualifier("userRealm") ==》 下面的方法名
        securityManager.setRealm(userRealm);


        return securityManager;
    }


    // 创建 realm 对象，需要自定义类:1
    @Bean
    public UserRealm userRealm(@Qualifier("matcher") HashedCredentialsMatcher matcher){
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }


    // 自定义密码加密
    @Bean(name = "matcher")
    public HashedCredentialsMatcher getHashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        // 设置加密规则
        matcher.setHashAlgorithmName("md5");
        // 设置加密次数
        matcher.setHashIterations(10);

        return matcher;
    }

    // 整合 ShiroDialect：用来整合shiro+thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
