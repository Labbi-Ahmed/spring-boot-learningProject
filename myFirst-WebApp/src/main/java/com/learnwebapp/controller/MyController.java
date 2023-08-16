package com.learnwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class MyController {
	@GetMapping("/say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! Labbi Ahmed";
	}
}
