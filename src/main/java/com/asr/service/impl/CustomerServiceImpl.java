package com.asr.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.asr.entity.Customer;
import com.asr.exception.CustomerNotFoundException;
import com.asr.repository.CustomerRepository;
import com.asr.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);
	@Autowired
	private CustomerRepository customerRepostory;

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
	
		return customerRepostory.save(customer);
	}

	@Override
	public Customer getCustomer(Long id) {
		// TODO Auto-generated method stub
		logger.info("Hello logger implemented");
		logger.info(customerRepostory.findById(id).get());
		return customerRepostory.findById(id).orElseThrow(
				() -> new CustomerNotFoundException("Customer not found in the DB with the given id : " + id));
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		logger.info("Hello logger implemented");
		logger.info(customerRepostory.findAll());
		return customerRepostory.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		customerRepostory.deleteById(id);
	}

	@Override
	public Customer updateCustomer(Long id, Customer customer) {
		Optional<Customer> oldCustomer = customerRepostory.findById(id);
		if (oldCustomer.isPresent()) {
			oldCustomer.get().setName(customer.getName());
			oldCustomer.get().setActivity(customer.getActivity());
			oldCustomer.get().setContact(customer.getContact());
		}
		customerRepostory.save(oldCustomer.get());

		return oldCustomer.get();
	}

	@Override
	public Customer partialUpdate(Long id, Map<String, Object> nameRequest) {
		// TODO Auto-generated method stub
		/*
		 * Customer oldCustomer = customerRepostory.findById(id).get(); List<String>
		 * keys = nameRequest.entrySet().stream().map(x ->
		 * x.getKey()).collect(Collectors.toList()); for (String key : keys) { switch
		 * (key) { case "name": oldCustomer.setName(nameRequest.get(key).toString());
		 * break; case "contact":
		 * oldCustomer.setContact(nameRequest.get(key).toString()); break; case
		 * "activity":
		 * 
		 * oldCustomer.setActivity(nameRequest.get(key).toString()); break;
		 * 
		 * } } customerRepostory.save(oldCustomer); return oldCustomer;
		 */
		Optional<Customer> oldCustomer = customerRepostory.findById(id);
		if (oldCustomer.isPresent()) {
			nameRequest.forEach((k, v) -> {
				Field field = ReflectionUtils.findField(Customer.class, k);
				field.setAccessible(true);
				ReflectionUtils.setField(field, oldCustomer.get(), v);
			});

		}
		Customer customer = customerRepostory.save(oldCustomer.get());
		return customer;

	}

}
