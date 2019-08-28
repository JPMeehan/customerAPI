package com.bah.app.customerapi;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.app.customerapi.inmemory.InMemoryCustomerRepository;

@RestController
@RequestMapping("/api/customers/")
public class CustomerAPI {
	
	public static int currId=0;
	
	@Autowired
	private InMemoryCustomerRepository inMemoryCustomerRepository;
	
	@GetMapping
	public ArrayList<Customer> getAll() {
		//return new Customer("tom", "y@yahoo.com", "123abc");
		//inMemoryCustomerRepository.createCustomerList();
		return inMemoryCustomerRepository.getAllCustomer();
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Customer newCustomer, 
			HttpRequest request, UriComponentsBuilder uri) {
		if (newCustomer.getId()!=0
				|| newCustomer.getUsername()==null
				|| newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		//newCustomer = inMemoryCustomerRepository. // TODO: Add way to add customer to the ArrayList
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newCustomer.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
		
	}
	
}
