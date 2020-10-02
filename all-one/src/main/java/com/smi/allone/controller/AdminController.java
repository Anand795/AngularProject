package com.smi.allone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.allone.domain.User;
import com.smi.allone.repository.UserRepository;
import com.smi.allone.service.ServiceDB;

@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ServiceDB serviceDb;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST , produces = "application/json")
	public User adminLogin(@RequestBody User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		User userdetail = userRepository.findByEmail(email);
		

		if (serviceDb.checking(user)) {
			return userdetail;
		} else {
			return userdetail;
		}
	}
	
//	Admin Register
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String userRegister(@RequestBody User user) {
		user.setRole("ADMIN");
		userRepository.save(user);
		return "Registered successfully";
	}

}
