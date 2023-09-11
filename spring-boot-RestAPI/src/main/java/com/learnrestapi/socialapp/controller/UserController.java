//package com.learnrestapi.socialapp.controller;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
//
//import java.net.URI;
//import java.util.List;
//
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.learnrestapi.socialapp.entity.User;
//import com.learnrestapi.socialapp.exception.UserNotFoundException;
//import com.learnrestapi.socialapp.service.UserDaoService;
//
//import jakarta.validation.Valid;
//
////@RestController
//@RequestMapping("/api/v1")
//public class UserController {
//
//	private UserDaoService service;
//	
//	public UserController(UserDaoService service) {
//		// TODO Auto-generated constructor stub
//		this.service = service;
//	}
//
//	@GetMapping("/users")
//	public ResponseEntity<Object[]> getAllUser(){
//		
//		List<User> users = service.findAll();
//		
//		return ResponseEntity.ok().body(users.toArray());
//	}
//	
//	// hateoas implement here 
//	@GetMapping("/users/{id}")
//	public ResponseEntity<EntityModel<User>> findUserById(@PathVariable int id){
//		User user = service.findById(id);
//		if(user == null) {
//			throw new UserNotFoundException("id not exist :"+id);
//		}
//		
//		EntityModel<User> entityModel = EntityModel.of(user);
//		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUser());;
//		entityModel.add(link.withRel("all-users"));
//		
//		return ResponseEntity.ok().body(entityModel);
//	}
//	
//	
//	@PostMapping("/users")
//	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
//		
//		User saveUser = service.save(user);
//		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//						.path("/{id}")
//						.buildAndExpand(saveUser.getId())
//						.toUri();
//		return ResponseEntity.created(location).build();
//	}
//	
//	@DeleteMapping("users/{id}")
//	public void deleteById(@PathVariable int id){
//		service.deleteById(id);
//		
//	}
//	
//	
//	
//}
