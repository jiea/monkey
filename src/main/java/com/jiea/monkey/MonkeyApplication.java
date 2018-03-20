package com.jiea.monkey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jiea.monkey.dao")
public class MonkeyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonkeyApplication.class, args);
	}
}
