package com.internal.zl.logicsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.internal.zl.logicsystem.mapper")
@EnableScheduling
public class LogicSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogicSystemApplication.class, args);
    }

}
