package com.leanr.jpajdbc.course.repository.springJpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leanr.jpajdbc.course.model.Course;

public interface MySpringJpaRepository extends JpaRepository<Course, Long>{
	
}
