package com.bunny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bunny.config.constant.Constant;
import com.bunny.config.response.Response;
import com.bunny.model.Address;
import com.bunny.model.dto.AddressDTO;
import com.bunny.service.AddressService;

@RestController
@RequestMapping(value = { "/address" })

public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping(value = "/addAddress", headers = "Accept=application/json")
	public ResponseEntity<Response> addAddress(@RequestBody AddressDTO address,
			@RequestParam(name = "User Id") String id) {

		Address addresss = addressService.addAddress(address, id);

		if (addresss != null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new Response(Constant.ADDRESS_DETAILS_ADDED, Constant.OK_RESPONSE_CODE));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new Response(Constant.ADDRESS_DETAILS_FAIL, Constant.BAD_REQUEST_RESPONSE_CODE));

	}

}
