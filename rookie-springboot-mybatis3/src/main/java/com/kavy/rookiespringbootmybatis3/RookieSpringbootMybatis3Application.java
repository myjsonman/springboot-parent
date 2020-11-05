package com.kavy.rookiespringbootmybatis3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.kavy.rookiespringbootmybatis3.dao")
public class RookieSpringbootMybatis3Application {

    public static void main(String[] args) {
        SpringApplication.run(RookieSpringbootMybatis3Application.class, args);
    }

}
