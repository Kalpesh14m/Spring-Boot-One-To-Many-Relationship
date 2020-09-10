package com.bunny.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bunny.model.Address;

@Repository
@Transactional
public interface AddressRepo extends JpaRepository<Address, Long> {

	public List<Address> findOrderByUserId(Long userId);

}
