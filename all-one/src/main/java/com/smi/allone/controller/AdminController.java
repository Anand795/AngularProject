package com.smi.allone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.allone.domain.Admin;
import com.smi.allone.domain.User;
import com.smi.allone.repository.AdminRepository;
import com.smi.allone.repository.UserRepository;
import com.smi.allone.service.ServiceDB;

@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ServiceDB serviceDb;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogin(@RequestBody Admin admin) {
		String email = admin.getEmail();
		String password = admin.getPassword();
		Admin emaildb = serviceDb.findByAdminEmail(email);
		Admin passwordDb = serviceDb.findByAdminPassword(password);
		if(emaildb != null && passwordDb != null) {
			return "Logged in Successfully";
		}
		else {
			return "Login UnSuccessful";
		}
	}
	
//	User Register
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String userRegister(@RequestBody Admin admin) {
		System.out.println("----------");
		adminRepository.save(admin);
		return "Registered successfully";
	}

}
