package com.zj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zj.mapper")
public class SpringbootSecurityDay2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityDay2Application.class, args);
    }

}
