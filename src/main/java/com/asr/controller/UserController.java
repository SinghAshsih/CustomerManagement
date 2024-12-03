package com.asr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asr.entity.Users;
import com.asr.service.impl.UserServiceImpl;
@RestController
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return userServiceImpl.register(user);
	}
}
