package com.apistory.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.apistory.admin.mapper")
public class ApiStoryAdmin {

    public static void main(String[] args) {
        SpringApplication.run(ApiStoryAdmin.class, args);
    }

}
