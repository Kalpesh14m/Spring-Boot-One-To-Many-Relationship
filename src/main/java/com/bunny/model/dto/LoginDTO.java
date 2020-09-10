package com.bunny.model.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginDTO {

	private String loginId;
	private String password;

	public LoginDTO() {
	}

	public LoginDTO(String loginId, String password) {
		this.loginId = loginId;
		this.password = password;
	}

	public String getloginId() {
		return loginId;
	}

	public void setloginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
