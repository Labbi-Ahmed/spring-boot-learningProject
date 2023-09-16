package com.learnrestapi.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.learnrestapi.todo.entity.UserTodo;
import com.learnrestapi.todo.model.UserTodoDTO;
import com.learnrestapi.todo.repository.JpaTodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

	private final JpaTodoRepository todoRepository;
	private final ModelMapper modelMapper;

	public List<UserTodoDTO> findByEmailTodos(String email) {
		// TODO Auto-generated method stub
		List<UserTodo> todoList = todoRepository.findByEmail(email);
		return todoList.stream().map(todo-> modelMapper.map(todo,UserTodoDTO.class )).toList();
		//return userTodoDao;
	}

	public UserTodoDTO save(UserTodo todo) {
		// TODO Auto-generated method stub
		UserTodo save = todoRepository.save(todo);
		
		return modelMapper.map(save, UserTodoDTO.class);
		
		
	}

	public UserTodo findbyId(Integer id) {
		// TODO Auto-generated method stub
		return todoRepository.findById(id).get();
	}

	public void deleteByid(Integer id) {
		
		todoRepository.deleteById(id);
		
	}
	
}
 