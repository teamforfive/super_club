package com.fiveofteam.super_club.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NameConfig {
    @Value("my.sessionInfoName")
    public String sessionInfoName;

}
