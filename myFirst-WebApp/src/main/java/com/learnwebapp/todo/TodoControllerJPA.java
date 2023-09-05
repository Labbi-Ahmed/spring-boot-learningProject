package com.learnwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

	private TodoRepositoryJPA todoService;
	
	public TodoControllerJPA(TodoRepositoryJPA todoService) {
		this.todoService = todoService;
	}
	
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String userName = getLoggedInUserName(model);
		List<Todo> todos =  todoService.findByUserName(userName);
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String userName = (String)model.get("name");
		Todo todo = new Todo(0, userName, "" , LocalDate.now(), false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo( ModelMap model, @Valid  Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		String userName = (String)model.get("name");
		todo.setUserName(userName);
		todoService.save(todo);
		return "redirect:list-todos";
	}
	
	//delete-todo
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	

	@RequestMapping(value="update-todo", method = RequestMethod.GET)
		public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
			
			Todo todo = todoService.findById(id).get();
			model.addAttribute("todo", todo);
			return "todo"; 
		}
		
		@RequestMapping(value="update-todo", method = RequestMethod.POST)
		public String updateTodo( ModelMap model, @Valid  Todo todo, BindingResult result) {
			
			if(result.hasErrors()) {
				return "todo";
			}
			String userName = (String)model.get("name");
			todo.setUserName(userName);
			todoService.save(todo);		
			return "redirect:list-todos";
		}
		
		private String getLoggedInUserName(ModelMap model) {
			 String name = SecurityContextHolder.getContext().getAuthentication().getName();
			 model.put("name", name);
			 return name; 
		}
}
