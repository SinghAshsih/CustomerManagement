package com.asr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asr.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	public Users findByUsername(String username);
}
