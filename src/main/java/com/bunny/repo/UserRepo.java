package com.bunny.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bunny.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	public Optional<User> findByEmail(String email);

}
