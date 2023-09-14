package com.labbi.spring_security_with_jwt.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional< User> findByEmail(String email);
}
