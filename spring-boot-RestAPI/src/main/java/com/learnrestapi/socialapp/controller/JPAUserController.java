package com.learnrestapi.socialapp.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learnrestapi.socialapp.entity.Post;
import com.learnrestapi.socialapp.entity.User;
import com.learnrestapi.socialapp.exception.UserNotFoundException;
import com.learnrestapi.socialapp.repository.JPAH2PostRepository;
import com.learnrestapi.socialapp.service.H2JPAService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class JPAUserController {

	private H2JPAService service;
	
	private JPAH2PostRepository postRepo;
	
	public JPAUserController(H2JPAService service, JPAH2PostRepository postRepo) {
		// TODO Auto-generated constructor stub
		this.service = service;
		this.postRepo = postRepo;
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> users = service.findAll();
		
		return ResponseEntity.ok().body(users);
	}
	
	// hateoas implement here 
	@GetMapping("/users/{id}")
	public ResponseEntity<EntityModel<User>> findUserById(@PathVariable int id){
		Optional<User> user = Optional.of(service.findById(id));
		if(user.isEmpty()) {
			throw new UserNotFoundException("id not exist :"+id);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUser());;
		entityModel.add(link.withRel("all-users"));
		
		return ResponseEntity.ok().body(entityModel);
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		
		User saveUser = service.saveuser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(saveUser.getId())
						.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("users/{id}")
	public void deleteById(@PathVariable int id){
		service.deleteById(id);
		
	}
	
	@GetMapping("/users/{id}/posts")
	public List<Post> retrivePostsForUser(@PathVariable int id){
		Optional<User> user = Optional.of(service.findById(id));
		if(user.isEmpty()) {
			throw new UserNotFoundException("id not exist :"+id);
		}
		
		return user.get().getPosts();
		
		
	}
	
	@GetMapping("/users/{id}/posts/{p_id}")
	public Post retrivePostsForUserPostId(@PathVariable int id, @PathVariable int p_id){
		Optional<User> user = Optional.of(service.findById(id));
		if(user.isEmpty()) {
			throw new UserNotFoundException("id not exist :"+id);
		}
		
		 Post post = user.get().getPosts().stream().filter(pst -> pst.getId()==p_id).findFirst().orElse(null);
		 
		 if(post == null) {
			 throw new PostNotFoundException("post id not exist: " + p_id);
		 }
		 
		 return post;
		
		
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id, @RequestBody Post post){
		Optional<User> user = Optional.of(service.findById(id));
		if(user.isEmpty()) {
			throw new UserNotFoundException("id not exist :"+id);
		}
		post.setUser(user.get());
		Post savePost = postRepo.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savePost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
		
		
	}
	
	
	
	
}
