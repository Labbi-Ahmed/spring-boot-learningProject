package com.learnwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

	@RequestMapping("/list-todo")
	public String listAllTodos() {
		return "listTodo";
	}
}
