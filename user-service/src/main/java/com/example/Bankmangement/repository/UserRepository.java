package com.example.Bankmangement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Bankmangement.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	public Optional<User> findByUsername(String username);
	public Boolean existsByUsername(String username);
	public User findById(long id);
}
