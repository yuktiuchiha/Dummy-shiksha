package com.dummshiksha.UniversityService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UniversityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityServiceApplication.class, args);
	}

}
