package com.fiveofteam.super_club.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SourceConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * @Description: 对文件的路径进行配置, 创建一个虚拟路径/file/** ，即只要在<img src="/file/images/20180522/9aa64b2b-a558-421e-929c-537ff0aecdba.jpg" />便可以直接引用图片
         *这是图片的物理路径 "file:/+本地图片的地址"
         * @Date： Create in 14:08 2017/12/20
         *
         */
//        //读取配置文件中的上传路径
//        Props prop = new Props("application.properties");
//        String url = prop.getProperty("sword.uploadPath");
//        registry.addResourceHandler("/file/**").addResourceLocations("file:"+url);
//        super.addResourceHandlers(registry);
//addResourceHandler是指你想在url请求的路径

//addResourceLocations是图片存放的真实路径

        registry.addResourceHandler("/image/**").addResourceLocations("file:f://Project/mypicture/");
        super.addResourceHandlers(registry);
    }
}


