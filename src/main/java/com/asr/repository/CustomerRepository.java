package com.asr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asr.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
