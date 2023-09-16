package com.learnrestapi.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistationRequest {
	
	private String email;
	
	private String name;

	private String password;

	

}
