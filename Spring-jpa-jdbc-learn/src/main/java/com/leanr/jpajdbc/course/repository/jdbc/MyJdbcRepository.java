package com.leanr.jpajdbc.course.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.leanr.jpajdbc.course.model.Course;

@Repository
public class MyJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplete;
	
	private static String INSERT_INTO = 
			"""
				INSERT INTO course(id,name,author)
				values(?, ?, ?);
			""";
	
	private static String DELETE_FROM = 
			"""
				DELETE FROM course where id = ?
			""";
	private static String SELECT_QUERY = 
			"""
				SELECT *  FROM course where id = ?
			""";
	
	public void insert(Course course) {
		springJdbcTemplete.update(INSERT_INTO,course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(long id) {
		springJdbcTemplete.update(DELETE_FROM, id);
	}
	
	public Course selectById(long id) {
		//ResultSet -> Bean => Row Mapper
		return springJdbcTemplete.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
	
	
}
