package com.movie.exception;

public class AddressNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int status;
	String message;

	public AddressNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public AddressNotFoundException(String message, int status) {
		super(message);
		this.message = message;
		this.status = status;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}