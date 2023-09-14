//package com.learnwebap.oauth2jwtsecurity.configure.basic;
//
//import java.util.List;
//import java.util.function.Function;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class BasicAuthConfiguration {
//
//	@Bean
//	JdbcUserDetailsManager inMemoryUserDetailsManager(DataSource dataSource) {
//		Function<String, String> encoder = input -> passwordEncoder().encode(input);
//
//		UserDetails userDetails1 = userDetails(encoder, "labib", "1122", List.of("USER", "ADMIN","EDITOR"));
//		UserDetails userDetails2 = userDetails(encoder, "rifat", "1122",List.of("USER"));
//
//		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//		
//		jdbcUserDetailsManager.createUser(userDetails1);
//		jdbcUserDetailsManager.createUser(userDetails2);
//		
//		return jdbcUserDetailsManager;
//	}
//
//	private UserDetails userDetails(Function<String, String> encoder, String username, String password, List<String> roles) {
//		return User.builder()
//				.passwordEncoder(encoder)
//				.username(username)
//				.password(password)
//				.roles(roles.toString())
//				.build();
//	}
//
//	@Bean
//	SecurityFilterChain securityFlChain(HttpSecurity http) throws Exception {
//
//		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
//
//		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		http.csrf().disable();
//		http.httpBasic();
//		http.headers().frameOptions().sameOrigin();
//		return http.build();
//	}
//
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	
//	
//	@Bean
//	public DataSource dataSource() {
//		return new EmbeddedDatabaseBuilder()
//				.setType(EmbeddedDatabaseType.H2)
//				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//				.build();
//	}
//
//}
