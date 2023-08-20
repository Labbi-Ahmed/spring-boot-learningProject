package com.learnwebapp.todo;

import java.time.LocalDate;
import java.util.List;

public class TodoService {

	public static List<Todo> todo;
	static {
		todo.add(new Todo(1,"labib", "Learn Java", LocalDate.now().plusYears(1), false));
		
		todo.add(new Todo(2,"labib", "Learn Spring", LocalDate.now().plusYears(2), false));

		todo.add(new Todo(3,"labib", "Learn Mysql", LocalDate.now().plusYears(3), false));

		todo.add(new Todo(4,"labib", "Learn AWS", LocalDate.now().plusYears(4), false));

		

	}
	
	public List<Todo> findByUsername(String userName){
		return todo;
	}
}
