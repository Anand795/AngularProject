package com.smi.allone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smi.allone.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//
//	User findByEmail(String email);
//
//	User findByPassword(String password);
	
	@Query("select u from User u where u.email=?1 and u.password=?2")
	List<User> check(String email,String password);

}
