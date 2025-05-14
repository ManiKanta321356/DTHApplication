package com.aurum.www.DTHApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.aurum.www.DTHApplication.repo")
public class DthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DthApplication.class, args);
	}

}
