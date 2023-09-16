package com.learnrestapi.users.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learnrestapi.users.entity.UserRegistation;
import com.learnrestapi.users.model.UserLogin;
import com.learnrestapi.users.model.UserRegistationRequest;
import com.learnrestapi.users.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@SessionAttributes("email")
public class UserController{
	
	private final UserService userService;

	@RequestMapping(value="", method = RequestMethod.GET )
	public List<UserRegistation> getAllUser(){
		List<UserRegistation> users = userService.findAllusers();
		return users;
	}
	
	@RequestMapping(value="/{email}", method = RequestMethod.GET )
	public UserRegistation getUserByEmail(@PathVariable String email){
		UserRegistation user = userService.findUserByEmail(email);
		return user;
	}
	@RequestMapping(value="/registation", method = RequestMethod.POST )
	public ResponseEntity<Boolean> createUser(@RequestBody UserRegistationRequest userR){
	
		UserRegistation userRegistation = new UserRegistation(userR.getEmail(), userR.getName(), userR.getPassword());
		UserRegistation save = userService.save(userRegistation);
		if(save == null) return ResponseEntity.status(201).body(false);
		return ResponseEntity.status(201).body(false);
		// return redirect to login api later
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST )
	public boolean loginUser( @RequestBody UserLogin user){

		boolean loginUser = userService.loginUser(user);
		if( loginUser) {
			
			return true;
		}
		
		return false;
	
		
	}
	
	
	@RequestMapping(value="/logout/{email}", method = RequestMethod.GET )
	public boolean logoutuser( @PathVariable String email){
	
		if(userService.logoutUser(email)) {
			return true;
		}
		return false;
			
	}
	
	
	
	
}
