package com.learnwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnwebapp.login.service.AuthService;

import org.springframework.ui.ModelMap;

@Controller
public class LoginController {

	private AuthService authService;
	
	
	
	public LoginController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@RequestMapping(value="login",method = RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model ) {
		
		if(authService.isValidUser(name, password)) {
			model.put("name", name);
			return "welcome";
		}
		model.put("errorMassage", "Invalid user");
		return "login";
	}
	
}
