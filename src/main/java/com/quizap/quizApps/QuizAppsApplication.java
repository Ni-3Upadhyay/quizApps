package com.quizap.quizApps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.quizap.quizApps"})
public class QuizAppsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppsApplication.class, args);
		System.out.println("Hello");
	}
}
