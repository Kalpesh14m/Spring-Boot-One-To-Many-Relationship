package com.bunny.service;

import com.bunny.model.Address;
import com.bunny.model.dto.AddressDTO;

public interface AddressService {

	public Address addAddress(AddressDTO address, String id);

}
