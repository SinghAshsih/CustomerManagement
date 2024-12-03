package com.asr.service;

import java.util.List;
import java.util.Map;

import com.asr.entity.Customer;

public interface CustomerService {
	Customer createCustomer(Customer customer);

	Customer getCustomer(Long id);

	List<Customer> getAllCustomer();

	void delete(Long id);

	Customer updateCustomer(Long id, Customer customer);

	Customer partialUpdate(Long id ,Map<String,Object>field);
	
}
