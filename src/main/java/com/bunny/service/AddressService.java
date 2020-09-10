package com.bunny.service;

import java.util.List;

import com.bunny.model.Address;
import com.bunny.model.dto.AddressDTO;

public interface AddressService {

	public boolean addAddress(AddressDTO address, Long userId);

	public List<Address> getUserAddress(Long userId);
	// Need to work
//	public boolean deleteAddress(Long addressId);

	public boolean updateAddress(Address address);
}
