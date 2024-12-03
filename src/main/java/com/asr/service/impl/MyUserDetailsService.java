package com.asr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.asr.entity.Users;
import com.asr.repository.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = userRepository.findByUsername(username);
		if (user == null) {
			System.out.println();
			throw new UsernameNotFoundException("User not found");
		}

		return new UserPrincipal(user);
	}


}
