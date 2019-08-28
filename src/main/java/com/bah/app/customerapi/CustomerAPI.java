package com.bah.app.customerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.app.customerapi.inmemory.InMemoryCustomerRepository;

@RestController
public class CustomerAPI {
	
//	public CustomerController getCustomer(String username, String email, String password) {
//		return new CustomerController(username, email, password);
//	}
	
	@Autowired
	private InMemoryCustomerRepository inMemoryCustomerRepository;
	
	@GetMapping("/api/register")
	public Customer getFirstCustomer() {
		//return new Customer("tom", "y@yahoo.com", "123abc");
		//inMemoryCustomerRepository.createCustomerList();
		return inMemoryCustomerRepository.getCustomer(1);
	}
	
}
