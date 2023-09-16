package com.learnrestapi.todo.model;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTodoDTO {
	
	private Integer id;

	private String descripton;
	
	private LocalDate targetDate;
		
	private boolean done;

	
}
