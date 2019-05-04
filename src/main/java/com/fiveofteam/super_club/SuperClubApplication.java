package com.fiveofteam.super_club;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("com.fiveofteam.super_club.dao")
public class SuperClubApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperClubApplication.class, args);
    }

}
