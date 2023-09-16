package com.apistory.admin;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.apistory.admin.mapper")
@EnableDubbo
public class ApiStoryAdmin {

    public static void main(String[] args) {
        SpringApplication.run(ApiStoryAdmin.class, args);
    }

}
