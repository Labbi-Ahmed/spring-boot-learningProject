package com.learnrestapi.model;

import java.util.List;

import com.learnrestapi.entity.UserTodo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDao {

	
	private String email;
	private String name;
	private List<UserTodo> todos;
		
	
}
