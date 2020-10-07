package com.smi.allone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smi.allone.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	List<Address> findByUserId(String id);


}
