package com.learnrestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnrestapi.model.ResponseDAO;
import com.learnrestapi.model.UserDao;
import com.learnrestapi.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController{
	
	private final UserService userService;

	@RequestMapping(value="/", method = RequestMethod.GET )
	public List<UserDao> getAllUser(){
		List<UserDao> users = userService.findAllusers();
		return users;
	}
	
	@RequestMapping(value="/{email}", method = RequestMethod.GET )
	public UserDao getUserByEmail(@RequestParam String email){
		UserDao user = userService.findUserByEmail(email);
		return user;
	}
}
