package com.bunny.model.dto;

import org.springframework.stereotype.Component;

@Component
public class AddressDTO {
	private String city;
	private String state;
	private String country;

	public AddressDTO() {
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
