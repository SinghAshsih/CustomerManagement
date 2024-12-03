package com.asr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asr.entity.Customer;
import com.asr.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/create")
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {

		Customer createCustomer = customerService.createCustomer(customer);

		return new ResponseEntity<Customer>(createCustomer, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> get(@PathVariable Long id) {
		Customer customer = customerService.getCustomer(id);
		return ResponseEntity.ok(customer);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAll() {
		List<Customer> allCustomer = customerService.getAllCustomer();
		return ResponseEntity.ok(allCustomer);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		customerService.delete(id);
		return new ResponseEntity<String>("Data deleted successfully", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		Customer updateCustomer = customerService.updateCustomer(id, customer);
		return new ResponseEntity<Customer>(updateCustomer, HttpStatus.OK);

	}

	@PatchMapping("/partial-update/{id}")
	public ResponseEntity<Customer> partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> field) {
		Customer updateCustomer = customerService.partialUpdate(id,field);
		return new ResponseEntity<Customer>(updateCustomer, HttpStatus.OK);
	}

}
