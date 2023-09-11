//package com.learnrestapi.socialapp.service;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Predicate;
//
//import org.springframework.stereotype.Service;
//
//import com.learnrestapi.socialapp.entity.User;
//
//@Service
//public class UserDaoService {
//
//	
//	private static int cnt = 0;
//	
//	private static List<User> users = new ArrayList<>();
//	
//	static {
//		users.add(new User(++cnt, "xyz", LocalDate.now().minusYears(30)));
//		users.add(new User(++cnt, "abc", LocalDate.now().minusYears(35)));
//		users.add(new User(++cnt, "mno", LocalDate.now().minusYears(25)));
//	}
//	
//	
//	
//	
//	public List<User> findAll() {
//		
//		return users;
//	}
//	
//	public User save(User user) {
//		user.setId(++cnt);
//		users.add(user);
//		return user;
//		
//		
//	}
//
//	public User findById(int id) {
//		Predicate<? super User> predicate = user-> user.getId() == id;
//		return users.stream().filter(predicate).findFirst().orElse(null);
//		
//	}
//
//	public void deleteById(int id) {
//		Predicate<? super User> predicate = user-> user.getId() == id;
//		users.removeIf(predicate);
//	}
//
//}
