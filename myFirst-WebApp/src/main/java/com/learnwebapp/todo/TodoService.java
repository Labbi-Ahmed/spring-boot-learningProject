package com.learnwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static int cnt = 0;
	public static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(++cnt,"labib", "Learn Java", LocalDate.now().plusYears(1), false));
		
		todos.add(new Todo(++cnt,"labib", "Learn Spring", LocalDate.now().plusYears(2), false));

		todos.add(new Todo(++cnt,"labib", "Learn Mysql", LocalDate.now().plusYears(3), false));

		todos.add(new Todo(++cnt,"labib", "Learn AWS", LocalDate.now().plusYears(4), false));

		

	}
	
	public void addTodo(String userName, String description, LocalDate targetDate, boolean done ) {
		todos.add(new Todo(++cnt, userName, description, targetDate, done));
	}
	
	public List<Todo> findByUsername( String userName){
		List<Todo> newTodos = todos.stream().filter(todo-> userName.equals(todo.getUserName())).toList();
		return newTodos;
	}

	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo-> todo.getId()==id;
		
		todos.removeIf(predicate);
	}

	
	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo-> todo.getId()==id;
		return todos.stream().filter(predicate).findFirst().get();
		
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}
}
