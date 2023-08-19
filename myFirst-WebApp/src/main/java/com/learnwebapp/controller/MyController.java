package com.learnwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class MyController {
	@GetMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		
		return "Say Hello";
	}
	
	@GetMapping("say-hello-html")
	@ResponseBody
	public String sayHello_html() {
		
		StringBuffer sp = new StringBuffer();
		
		sp.append("<html><head><title>This is my page</title></head><body>HI</body></html>");
		
		return sp.toString();
	}
	
	
	@GetMapping("say-hello-jsp")
	public String sayHelloJSP() {
		
		return "sayHello";
	}
	
}
