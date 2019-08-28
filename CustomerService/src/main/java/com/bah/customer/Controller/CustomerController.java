package com.bah.customer.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.customer.Repository.Customer;
import com.bah.customer.Repository.InMemoryCustomerRepository;

@RestController
public class CustomerController {
	@Autowired 
	InMemoryCustomerRepository inMemoryCustomerRepository;
	
//	@GetMapping
//	public ArrayList<Customer> getAllCustomers() {
//		return inMemoryCustomerRepository.getAllCustomers();
//	}
	
//	@RequestMapping()
//	public String test() {
//		return "HEllo World";
//	}
	
	@GetMapping("/api/register")
	public Customer getCustomer(@PathVariable String name) {
		return inMemoryCustomerRepository.getCustomer("frank");
	}
	
}
