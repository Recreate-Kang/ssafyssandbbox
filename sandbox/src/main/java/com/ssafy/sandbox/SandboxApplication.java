package com.ssafy.sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SandboxApplication {

	public static void main(String[] args) {
		System.getenv().forEach((key, value) -> System.out.println(key + " = " + value));
		SpringApplication.run(SandboxApplication.class, args);
	}

}
