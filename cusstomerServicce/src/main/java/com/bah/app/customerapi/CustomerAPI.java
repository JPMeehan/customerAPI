package com.bah.app.customerapi;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bah.app.customerapi.inmemory.InMemoryCustomerRepository;

@RestController
public class CustomerAPI {
	
//	public CustomerController getCustomer(String username, String email, String password) {
//		return new CustomerController(username, email, password);
//	}
	
	@Autowired
	private InMemoryCustomerRepository inMemoryCustomerRepository;
	
	@GetMapping("/api/customer")
	public ArrayList<Customer> getAllCustomers() {
		return inMemoryCustomerRepository.getAllCustomers();
	}
	
	@GetMapping("/api/customer/{name}")
	public Customer getCustomer(@PathVariable String name) {
	
		return inMemoryCustomerRepository.getCustomer(name);
	}
	
}
