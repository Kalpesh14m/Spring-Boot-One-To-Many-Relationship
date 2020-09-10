package com.bunny.service;

import java.util.List;

import com.bunny.model.User;
import com.bunny.model.dto.RegistrationDTO;

public interface UserService {

	public boolean registerUser(RegistrationDTO request);

	public List<User> getUsers();

	public User getUserById(Long userId);

	// Need to work
	// public void deleteUser(Long userId);

}
