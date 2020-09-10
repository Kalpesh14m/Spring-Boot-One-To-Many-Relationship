package com.bunny.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bunny.model.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
