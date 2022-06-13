package com.li.diy;

// 方式三：使用注解方式实现aop

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect // 标注这个类是一个切面
public class AnnotataionPointCut {

    @Before("execution(* com.li.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("方法执行前");
    }

    @After("execution(* com.li.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("方法执行后");
    }

    // 在环绕增强中，我们可以给定一个参数，代表我们获取处理的接入点
    @Around("execution(* com.li.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("方法环绕");

        Signature signature = jp.getSignature();// 获得签名
        System.out.println("签名"+ signature);

        // 执行方法
        Object proceed = jp.proceed();

        System.out.println("环绕后");
    }

}
