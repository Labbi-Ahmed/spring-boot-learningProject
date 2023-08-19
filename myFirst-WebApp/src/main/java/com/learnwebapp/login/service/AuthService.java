package com.learnwebapp.login.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

	public boolean isValidUser(String name, String pass) {
		boolean isValidName  = name.equals("labib");
		boolean isValidPass = pass.equals("labib");
		
		return isValidName && isValidPass;
	}
}
