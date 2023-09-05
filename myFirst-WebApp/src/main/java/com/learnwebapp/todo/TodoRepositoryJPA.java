package com.learnwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepositoryJPA  extends JpaRepository<Todo, Integer>{
	public List<Todo> findByUserName(String username);
}
