package com.learnwebap.oauth2jwtsecurity.configure.jwt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
public class JWTSecurityConfiguration {

	@Bean
	SecurityFilterChain securityFlChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.csrf().disable();
		
		http.httpBasic();
		
		http.headers().frameOptions().sameOrigin();
		
		http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
		
		return http.build();
	}

	@Bean
	JdbcUserDetailsManager inMemoryUserDetailsManager(DataSource dataSource) {
		Function<String, String> encoder = input -> passwordEncoder().encode(input);

		UserDetails userDetails1 = userDetails(encoder, "labib", "1122", List.of("USER", "ADMIN", "EDITOR"));
		UserDetails userDetails2 = userDetails(encoder, "rifat", "1122", List.of("USER"));

		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

		jdbcUserDetailsManager.createUser(userDetails1);
		jdbcUserDetailsManager.createUser(userDetails2);

		return jdbcUserDetailsManager;
	}

	private UserDetails userDetails(Function<String, String> encoder, String username, String password,
			List<String> roles) {
		return User.builder().passwordEncoder(encoder).username(username).password(password).roles(roles.toString())
				.build();
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION).build();
	}
 
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	public KeyPair keyPair() {
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			return keyPairGenerator.generateKeyPair();
			
		} catch (Exception ex) {
			 throw new RuntimeException(ex);
		}
	}
	
	@Bean
	public RSAKey rsaKey(KeyPair keyPair) {
		
		return new RSAKey.Builder((RSAPublicKey)keyPair.getPublic())
					.privateKey(keyPair.getPrivate())
					.keyID(UUID.randomUUID().toString())
					.build();
	}
	
	@Bean
	public JWKSource<SecurityContext> jwtSource (RSAKey rsaKey) {
		JWKSet jwkSet = new JWKSet(rsaKey);
		
		return (jwtSelector,context) -> jwtSelector.select(jwkSet);
		
	}
	
	@Bean
	public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {
		return NimbusJwtDecoder
				.withPublicKey(rsaKey.toRSAPublicKey())
				.build();
	}
	
	@Bean
	public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwtSource ) {
		return new NimbusJwtEncoder(jwtSource);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	
}

//{
//	@Bean
//	public KeyPair keyPair() {
//		try {
//			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//			keyPairGenerator.initialize(2048);
//			return keyPairGenerator.generateKeyPair();
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
//
//	}
//
//	@Bean
//	public RSAKey rsaKey(KeyPair keyPair) {
//
//		return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic()).privateKey(keyPair.getPrivate())
//				.keyID(UUID.randomUUID().toString()).build();
//
//	}
//
//	@Bean
//	public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
//		JWKSet jwkSet = new JWKSet(rsaKey);
//
//		return (jwkSelector, context) -> jwkSelector.select(jwkSet);
//	}
//
//	@Bean
//	public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {
//		return NimbusJwtDecoder.withPublicKey(rsaKey.toRSAPublicKey()).build();
//	}
//
//	@Bean
//	public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
//		return new NimbusJwtEncoder(jwkSource);
//
//	}

//}
