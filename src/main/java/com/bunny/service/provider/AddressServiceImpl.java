package com.bunny.service.provider;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bunny.model.Address;
import com.bunny.model.User;
import com.bunny.model.dto.AddressDTO;
import com.bunny.repo.AddressRepo;
import com.bunny.repo.UserRepo;
import com.bunny.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private AddressRepo addressRepo;

	@Override
	@Transactional
	public Address addAddress(AddressDTO address, String id) {
		Optional<User> user = userRepo.findById(Long.parseLong(id));
		Address add = new Address();
		BeanUtils.copyProperties(address, add);
		add.setUser(user.get());
		user.get().getAddress().add(add);
		addressRepo.save(add);
		return add;
	}

}
