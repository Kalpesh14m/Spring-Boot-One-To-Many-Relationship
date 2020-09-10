package com.movie.exception;

public class UserAlreadyRegisteredException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyRegisteredException(String msg) {
		super(msg);
	}
}
