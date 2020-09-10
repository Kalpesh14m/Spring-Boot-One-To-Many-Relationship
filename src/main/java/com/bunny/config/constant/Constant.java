package com.bunny.config.constant;

import org.springframework.http.HttpStatus;

public class Constant {

	private Constant() {
	}

	public static final int OK_RESPONSE_CODE = 200;
	public static final int CREATED_RESPONSE_CODE = 201;
	public static final int ALREADY_EXIST_EXCEPTION_STATUS = 208;
	public static final int NOTE_NOT_FOUND_EXCEPTION_STATUS = 300;
	public static final int BAD_REQUEST_RESPONSE_CODE = 400;
	public static final int NOT_FOUND_RESPONSE_CODE = 404;
	public static final int BAD_GATEWAY_RESPONSE_CODE = 502;
	public static final int ACCEPT_RESPONSE_CODE = HttpStatus.ACCEPTED.value();
	public static final int EXPECTATION_FAILED_RESPONSE_CODE = HttpStatus.EXPECTATION_FAILED.value();

	public static final String USER_FOUND = "User Found";
	public static final String USER_NOT_FOUND_EXCEPTION_MESSAGE = "User not found!";
	public static final String USER_REGISTER_SUCESSFULLY = "User Registration Sucessfully Done.";
	public static final String USER_REGISTER_FAILED = "User Registration Failed";
	public static final String USER_ALREADY_REGISTER_MESSAGE = "User Already register";
	public static final String USER_DETAILS_UPDATED_SUCCESSFULLY = "User Details Updated Successfully";

	public static final String ADDRESS_DETAILS_ADDED = "address details added succefully";
	public static final String ADDRESS_DETAILS_FAIL = " address details failed to add ";
	public static final String ADDRESS_DETAILS_FOUND = "address details found for required type succefully";
	public static final String ADDRESS_DETAILS_NOT_fOUND = " not found address details for required type ";
}