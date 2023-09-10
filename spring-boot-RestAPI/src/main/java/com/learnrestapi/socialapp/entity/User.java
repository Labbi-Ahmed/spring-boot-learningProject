package com.learnrestapi.socialapp.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@JsonProperty("user_Id")
	private int id;
	
	@Size(min = 2, message="Name should have atleast 2 characters")
	@JsonProperty("full name")
	private String name;
	
	@Past(message="Birth Date should be past")
	private LocalDate birthDay;
	
	
}
