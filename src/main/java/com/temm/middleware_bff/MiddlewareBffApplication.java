package com.temm.middleware_bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MiddlewareBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddlewareBffApplication.class, args);
	}

}
