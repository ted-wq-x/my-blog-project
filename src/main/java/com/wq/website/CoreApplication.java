package com.wq.website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wq.website.dao")
@SpringBootApplication(scanBasePackages = "com.wq.website")
public class CoreApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
}
