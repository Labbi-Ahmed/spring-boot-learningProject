package com.learnrestapi.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnrestapi.users.entity.LoginUser;

public interface JPALoginUserRepository extends JpaRepository<LoginUser, String> {

	
}
