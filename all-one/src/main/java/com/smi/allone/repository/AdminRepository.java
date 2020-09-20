package com.smi.allone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smi.allone.domain.Admin;
import com.smi.allone.domain.User;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByEmail(String email);

	Admin findByPassword(String password);

}
