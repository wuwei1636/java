package com.li.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class swaggerConfig {


    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("a");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("b");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("c");
    }

    //配置了swagger的docket实例
    @Bean
    public Docket docket(Environment environment){

        // 设置要显示的swagger环境
        Profiles pro = Profiles.of("dev");
        //获取项目的环境
        boolean b = environment.acceptsProfiles(pro);



        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("lks")
                .enable(b)
                .select()
                // RequestHandlerSelectors 配置要扫描接口的方式
                // basePackage 指定要扫描的包
                // any() 扫描全部
                // none() 都不扫描
                //withClassAnnotation() 扫描类上的注解，参数是一个注解的反射对象
                // withMethodAnnotation() 扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.li.swagger.controller"))
                // paths  过滤带有（）请求路径的接口
                .build();
    }

    // 配置swagger的信息=apiInfo
    private ApiInfo apiInfo(){

        Contact contact = new Contact("李坤松", "https://nan-bluesky.top/", "1537628435@qq.com");

        return new ApiInfo(
                "李坤松的swagger文档",
                "遇事不决，但问春风",
                "v1.0",
                "https://nan-bluesky.top/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()

        );
    }

}
