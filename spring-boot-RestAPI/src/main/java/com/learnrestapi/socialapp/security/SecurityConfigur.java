package com.learnrestapi.socialapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigur {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception{
		
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		
		return http.build();
	}

}
