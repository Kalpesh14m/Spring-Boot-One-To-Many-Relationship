package com.bunny.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bunny.config.constant.Constant;
import com.bunny.config.response.Response;
import com.bunny.model.dto.RegistrationDTO;
import com.bunny.service.UserService;
import com.movie.exception.UserException;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = { "/users" })
@Api(value = "User Controller")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/register", headers = "Accept=application/json")
	public ResponseEntity<Response> register(@RequestBody RegistrationDTO request) throws IOException, UserException {
		if (userService.registerUser(request)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new Response(Constant.USER_REGISTER_SUCESSFULLY, Constant.OK_RESPONSE_CODE));
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new Response(Constant.USER_REGISTER_FAILED, Constant.BAD_REQUEST_RESPONSE_CODE));
		}
	}
}
