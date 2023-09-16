package com.learnrestapi.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnrestapi.todo.entity.UserTodo;

public interface JpaTodoRepository extends JpaRepository<UserTodo, Integer> {
	List<UserTodo> findByEmail(String email);
}
