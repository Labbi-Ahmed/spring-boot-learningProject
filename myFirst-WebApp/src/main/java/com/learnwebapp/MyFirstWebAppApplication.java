 package com.learnwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MyFirstWebAppApplication extends SpringBootServletInitializer {

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(MyFirstWebAppApplication.class);
//	}
//	
	public static void main(String[] args) {
		SpringApplication.run(MyFirstWebAppApplication.class, args);
	}

}
