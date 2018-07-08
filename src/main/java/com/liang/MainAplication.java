package com.liang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liang.dao")
public class MainAplication {
    public static void main(String args[]){
        SpringApplication.run(MainAplication.class);
    }
}
