package com.toyProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toyProject.models.entity.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	// JPA 네이밍 쿼리
	// SELECT * FROM User WHERE username = ? AND password = ?;
	Optional<User> findByUsernameAndPassword(String username, String password);
	
}
