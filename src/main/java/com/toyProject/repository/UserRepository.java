package com.toyProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toyProject.models.entity.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
