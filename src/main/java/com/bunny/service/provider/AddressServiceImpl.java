package com.bunny.service.provider;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bunny.config.constant.Constant;
import com.bunny.model.Address;
import com.bunny.model.User;
import com.bunny.model.dto.AddressDTO;
import com.bunny.repo.AddressRepo;
import com.bunny.repo.UserRepo;
import com.bunny.service.AddressService;
import com.movie.exception.AddressNotFoundException;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private AddressRepo addressRepo;

	@Override
	public boolean addAddress(AddressDTO address, Long userId) {
		Optional<User> user = userRepo.findById(userId);
		Address add = new Address();
		BeanUtils.copyProperties(address, add);
		add.setUser(user.get());
		addressRepo.save(add);
		return true;
	}

	@Override
	public List<Address> getUserAddress(Long userId) {
		List<Address> address = addressRepo.findOrderByUserId(userId);
		if (address == null) {
			throw new AddressNotFoundException(Constant.ADDRESS_DETAILS_NOT_fOUND, Constant.NOT_FOUND_RESPONSE_CODE);
		}
		return address;
	}

	@Override
	public boolean updateAddress(Address addressObj) {
		Optional<Address> maybeAddressPresent = addressRepo.findById(addressObj.getAddressId());
		if (!maybeAddressPresent.isPresent()) {
			throw new AddressNotFoundException(Constant.ADDRESS_DETAILS_NOT_fOUND, Constant.NOT_FOUND_RESPONSE_CODE);
		}
		addressObj.setUser(maybeAddressPresent.get().getUser());
		addressRepo.save(addressObj);
		return true;
	}
	// Need to work
//	@Override
//	public boolean deleteAddress(Long addressId) {
//		Optional<Address> maybeAddressObj = addressRepo.findById(addressId);
//		if (!maybeAddressObj.isPresent()) {
//			throw new AddressNotFoundException(Constant.ADDRESS_DETAILS_NOT_fOUND, Constant.NOT_FOUND_RESPONSE_CODE);
//		}
//		addressRepo.deleteById(addressId);
//		return true;
//	}

}
