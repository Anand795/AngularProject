package com.smi.allone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.allone.domain.User;
import com.smi.allone.repository.UserRepository;
import com.smi.allone.service.ServiceDB;


@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ServiceDB serviceDb;
	
//	user login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(@RequestBody User user ) {
		String email = user.getEmail();
		String password = user.getPassword();
		
//		User emaildb = serviceDb.findByEmail(email);
//		User passwordDb = serviceDb.findByPassword(password);
		if(serviceDb.checking(user)) {
			return "Logged in Successfully";
		}
		else {
			return "Login UnSuccessful";
		}
//		if(emaildb != null && passwordDb != null) {
//			return "Logged in Successfully";
//		}
//		else {
//			return "Login UnSuccessful";
//		}
		
		
	}

//	User Register
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String userRegister(@RequestBody User user) {
		System.out.println("----------");
		userRepo.save(user);
		return "Registered successfully";
	}

}
