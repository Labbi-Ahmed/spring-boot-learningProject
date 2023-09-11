package com.learnrestapi.socialapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learnrestapi.socialapp.entity.User;
import com.learnrestapi.socialapp.repository.JPAH2UserRepository;

import jakarta.validation.Valid;

@Service
public class H2JPAService {

	JPAH2UserRepository repo;

	public H2JPAService(JPAH2UserRepository repo) {
		this.repo = repo;
	}
	
	public List<User> findAll(){
		return repo.findAll();
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	public User saveuser( User user) {
		repo.save(user);
		return user;
	}

	public void deleteById(int id) {
		repo.deleteById(id);
		
	}
	
}
