package com.bunny.config.response;

import org.springframework.stereotype.Component;

@Component
public class UserResponse {

	private Object data;

	public UserResponse() {
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}