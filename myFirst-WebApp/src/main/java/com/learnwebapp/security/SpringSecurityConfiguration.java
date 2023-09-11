package com.learnwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
	
		Function<String, String> passwordEncoder = input-> passwordEncoder().encode(input);
		UserDetails userDetails1 = createUserDetails(passwordEncoder, "labib", "1234");
		UserDetails userDetails2 = createUserDetails(passwordEncoder, "rifat", "1234");
		
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
		
				
	}

	private UserDetails createUserDetails(Function<String, String> passwordEncoder, String username, String password) {
		UserDetails userDetails = User.builder().
				passwordEncoder(passwordEncoder).
				username(username).
				password(password).
				roles("USER", "ADMIN").
				build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	// All url are protected
	// login form shown for all unathorize request
	//csrf disable 
	// frames disable
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}
}
