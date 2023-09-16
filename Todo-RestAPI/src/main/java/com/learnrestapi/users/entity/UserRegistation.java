package com.learnrestapi.users.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author labib-ahmed
 *
 */
@Entity(name = "user")
public class UserRegistation  {

	@Id
	private String email;
	
	private String name;

	private String password;

	private final String role = "USER";
	
	
	

	public UserRegistation() {
		super();
	}

	public UserRegistation(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserRegistation [email=" + email + ", name=" + name + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	

}
