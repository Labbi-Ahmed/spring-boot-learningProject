package com.learnwebap.oauth2jwtsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learnwebap.oauth2jwtsecurity.entity.User;

@RestController
public class UserController {

	
	private static final List<User> USERS = new ArrayList<>(); 
			static {
				USERS.add(new User("labib"));
				USERS.add(new User("habib"));
				USERS.add(new User("rakib"));
			}
			
	@GetMapping("/users")
	public String getUser() {
		return "Labbi Ahmed";
	}
	
	@GetMapping("/users-all")
	public List<User> getUsers() {
		
		return  USERS;
	}
	
	@PostMapping("/users")
	public User SetUser(@RequestBody User user) {
		USERS.add(user);
		return user;
	}
	
	
	
}
