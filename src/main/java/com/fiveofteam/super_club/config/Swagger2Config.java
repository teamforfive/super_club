package com.fiveofteam.super_club.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger2Config{
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .forCodeGeneration(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fiveofteam.super_club.controller"))  // 指定controller存放的目录路径
                //过滤生成链接
                .paths(PathSelectors.any())
                .build();

    }

    //api接口作者相关信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("FWorldCodeZ", "", "1406399470@qq.com");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .license("Apache License Version 2.0")
                .title("超级社团")
                .description("接口文档")
                .contact(contact)
                .version("1.0")
                .build();
        return apiInfo;
    }
}