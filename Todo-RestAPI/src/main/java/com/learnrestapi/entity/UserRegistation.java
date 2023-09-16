package com.learnrestapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class UserRegistation  {

	@Id
	private String name;
	
	private String email;

	private String password;

	private String role = "USER";

}
