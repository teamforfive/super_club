package com.fiveofteam.super_club;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan("com.fiveofteam.super_club.dao")
public class SuperClubApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperClubApplication.class, args);
    }

}
