package com.learnrestapi.todo;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learnrestapi.todo.entity.UserTodo;
import com.learnrestapi.todo.model.UserTodoDAO;
import com.learnrestapi.todo.model.UserTodoDTO;
import com.learnrestapi.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todos")
@SessionAttributes("email")
public class TodoController {
	
	private final TodoService todoServic;
	private final ModelMapper modelMapper;
	
	@RequestMapping(value="/{email}", method = RequestMethod.GET)
	public List<UserTodoDTO> getTodosOfUser(@PathVariable String email){
		return todoServic.findByEmailTodos(email);
	}
	
	
	@RequestMapping(value="/add-todo/{email}", method = RequestMethod.POST)
	public void createTodo(  @PathVariable String email, @RequestBody UserTodoDAO tododao) {
		UserTodo todo = modelMapper.map(tododao, UserTodo.class);
		todo.setEmail(email);
		
		todoServic.save(todo);
	}
	
	
	@RequestMapping(value="/update-todo", method = RequestMethod.GET)
	public UserTodoDTO showUpdatePage(@RequestParam Integer id) {
		UserTodo userTodo = todoServic.findbyId(id);
		UserTodoDTO dto = modelMapper.map(userTodo, UserTodoDTO.class);
		return dto;
	}
	
	
	
	@RequestMapping(value="/update-todo", method = RequestMethod.POST)
	public void updateTodo( @RequestBody UserTodoDTO todoDto) {
		UserTodo todo = modelMapper.map(todoDto, UserTodo.class);
		todoServic.save(todo);
		
	}
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.DELETE)
	public void deleteTodo(@RequestParam Integer id) {
		todoServic.deleteByid(id);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
