package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.entity.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findById(String id);
}
