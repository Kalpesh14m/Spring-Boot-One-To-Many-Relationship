package com.bunny.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@PostMapping(value = "/{userId}", headers = "Accept=application/json")
	public ResponseEntity<Response> addAddress(@RequestBody AddressDTO address, @PathVariable Long userId) {
		if (addressService.addAddress(address, userId)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new Response(Constant.ADDRESS_DETAILS_ADDED, Constant.OK_RESPONSE_CODE));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new Response(Constant.ADDRESS_DETAILS_FAIL_TO_ADD, Constant.BAD_REQUEST_RESPONSE_CODE));
	}

	@GetMapping("/{userId}")
	public List<Address> address(@PathVariable Long userId) {
		return addressService.getUserAddress(userId);
	}

	@PutMapping("/")
	public ResponseEntity<Response> updateAddress(@RequestBody Address address) {
		if (addressService.updateAddress(address)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new Response(Constant.ADDRESS_DETAILS_UPDATED, Constant.OK_RESPONSE_CODE));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new Response(Constant.ADDRESS_DETAILS_FAIL_TO_UPDATE, Constant.BAD_REQUEST_RESPONSE_CODE));
	}

	// Need to work
//	@DeleteMapping("/{addressId}")
//	public ResponseEntity<Response> deleteAddress(@PathVariable Long addressId) {
//		if (addressService.deleteAddress(addressId)) {
//			return ResponseEntity.status(HttpStatus.OK)
//					.body(new Response(Constant.ADDRESS_DETAILS_DELETED, Constant.OK_RESPONSE_CODE));
//		}
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//				.body(new Response(Constant.ADDRESS_DETAILS_FAIL_TO_DELETE, Constant.BAD_REQUEST_RESPONSE_CODE));
//	}

}
