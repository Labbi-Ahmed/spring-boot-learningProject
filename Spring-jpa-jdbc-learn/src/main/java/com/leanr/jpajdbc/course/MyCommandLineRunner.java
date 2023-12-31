package com.leanr.jpajdbc.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.leanr.jpajdbc.course.model.Course;
import com.leanr.jpajdbc.course.repository.springJpa.MySpringJpaRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner{
	
//	@Autowired
//	MyJpaRepository repo;
	
	@Autowired
	MySpringJpaRepository repo;
	
	
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Course(1, "Learn JAVA", "Lipu"));
		repo.save(new Course(2, "Learn Jpa", "Lipu"));
		repo.save(new Course(3, "Learn Jdbc", "Lipu"));
		repo.save(new Course(4, "Learn Spring", "Lipu"));
		
		repo.deleteById(1l);
		
		System.out.println(repo.findById(3l));
//		System.out.println(repo.count());
		
	}
}
