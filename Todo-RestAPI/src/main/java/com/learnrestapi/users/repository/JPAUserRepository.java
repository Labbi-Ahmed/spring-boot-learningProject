package com.learnrestapi.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnrestapi.users.entity.UserRegistation;

public interface JPAUserRepository  extends JpaRepository<UserRegistation, String>{
	
	UserRegistation findByEmailAndPassword(String email, String password);

}
