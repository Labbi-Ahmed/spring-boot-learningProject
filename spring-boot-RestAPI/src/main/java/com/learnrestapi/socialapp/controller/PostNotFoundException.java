package com.learnrestapi.socialapp.controller;

public class PostNotFoundException extends RuntimeException {

	public PostNotFoundException(String message) {
		super(message);
	}
}
