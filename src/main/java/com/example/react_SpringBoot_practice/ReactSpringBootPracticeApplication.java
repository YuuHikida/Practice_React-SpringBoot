package com.example.react_SpringBoot_practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.react_SpringBoot_practice.mapper")
public class ReactSpringBootPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactSpringBootPracticeApplication.class, args);

	}

}
