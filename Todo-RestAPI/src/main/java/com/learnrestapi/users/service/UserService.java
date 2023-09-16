package com.learnrestapi.users.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.learnrestapi.users.entity.LoginUser;
import com.learnrestapi.users.entity.UserRegistation;
import com.learnrestapi.users.model.UserLogin;
import com.learnrestapi.users.repository.JPALoginUserRepository;
import com.learnrestapi.users.repository.JPAUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final JPAUserRepository repository;
	private final JPALoginUserRepository loginUserRepository;

	public List<UserRegistation> findAllusers() {
		// TODO Auto-generated method stub
		return repository.findAll();

	}

	public UserRegistation findUserByEmail(String email) {
		// TODO Auto-generated method stub
//		return repository.findByEmail(email);
		return repository.findById(email).get();
	}

	public UserRegistation save(UserRegistation userRegistation) {
		// TODO Auto-generated method stub
		UserRegistation emailUsed = repository.findById(userRegistation.getEmail()).orElse(null);

		if (emailUsed == null) {
			return repository.save(userRegistation);

		}
		return null;

	}

	public boolean loginUser(UserLogin user) {

		LoginUser logedin = loginUserRepository.findById(user.getEmail()).orElse(null);

		UserRegistation userExist = repository.findByEmailAndPassword(user.getEmail(), user.getPassword());

		if (logedin == null && userExist != null) {
			LoginUser save = loginUserRepository.save(new LoginUser(user.getEmail(), true));

			return save != null;
		}
		return false;
	}

	public boolean logoutUser(String email) {

		LoginUser logedin = loginUserRepository.findById(email).orElse(null);
		if (logedin != null) {
			loginUserRepository.deleteById(email);
			return true;
		}
		return false;
	}

}
