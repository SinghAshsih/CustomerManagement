package com.asr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.asr.entity.Users;
import com.asr.repository.UsersRepository;

@Service
public class UserServiceImpl {

	@Autowired
	private UsersRepository userRepository;


	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	
	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
