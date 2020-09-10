package com.bunny.service.provider;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bunny.config.constant.Constant;
import com.bunny.model.User;
import com.bunny.model.dto.RegistrationDTO;
import com.bunny.repo.UserRepo;
import com.bunny.service.UserService;
import com.movie.exception.UserAlreadyRegisteredException;
import com.movie.exception.UserNotFoundException;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo userRepository;

	public boolean registerUser(RegistrationDTO userDetails) {

		Optional<User> userExists = userRepository.findByEmail(userDetails.getEmail());
		if (userExists.isPresent()) {
			throw new UserAlreadyRegisteredException(Constant.USER_ALREADY_REGISTER_MESSAGE);
		}
		User userEntity = new User();
		BeanUtils.copyProperties(userDetails, userEntity);
		userRepository.save(userEntity);
		return true;
	}

	public User getUserById(Long userId) {
		Optional<User> maybeUser = userRepository.findById(userId);
		if (!maybeUser.isPresent()) {
			throw new UserNotFoundException(Constant.USER_NOT_FOUND_EXCEPTION_MESSAGE,
					Constant.NOT_FOUND_RESPONSE_CODE);
		}
		return maybeUser.get();
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

//Need to work
//	public void deleteUser(Long id) {
//		userRepository.deleteById(id);
//	}

}
