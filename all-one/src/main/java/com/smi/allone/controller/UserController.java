package com.smi.allone.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.allone.domain.User;

import com.smi.allone.repository.UserRepository;
import com.smi.allone.service.ServiceDB;

@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;


	@Autowired
	private ServiceDB serviceDb;

//	user login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User userLogin(@RequestBody User user) {
		String email = user.getEmail();
		String password = user.getPassword();

//		User emaildb = serviceDb.findByEmail(email);
//		User passwordDb = serviceDb.findByPassword(password);

		User userdetail = userRepo.findByEmail(email);
		if (serviceDb.checking(user)) {
			return userdetail;
		} else {
			return userdetail;
		}
//		if(emaildb != null && passwordDb != null) {
//			return "Logged in Successfully";
//		}
//		else {
//			return "Login UnSuccessful";
//		}

	}

//	User Register
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String userRegister(@RequestBody User user) {
		
//		MAPPING REFFERENCE
//		Role roles = new Role();
//		roles.setRoleName("USER")
//		Set<Role> s = new HashSet<Role>();
//		s.add(roles);
//		user.setRoles(s);
//		userRepo.save(user);
		
		user.setRole("USER");
		userRepo.save(user);
		return "Registered successfully";

	}

}
