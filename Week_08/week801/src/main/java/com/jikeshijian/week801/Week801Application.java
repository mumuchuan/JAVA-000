package com.jikeshijian.week801;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jikeshijian")
@MapperScan("com.week07")
public class Week801Application {

    public static void main(String[] args) {
        SpringApplication.run(Week801Application.class, args);
    }

}
