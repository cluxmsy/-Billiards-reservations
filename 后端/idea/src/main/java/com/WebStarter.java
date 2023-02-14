package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot启动类
 */
@SpringBootApplication
@MapperScan("com.mapper")
public class WebStarter {
    public static void main(String[] args) {
        SpringApplication.run(WebStarter.class,args);
    }
}
