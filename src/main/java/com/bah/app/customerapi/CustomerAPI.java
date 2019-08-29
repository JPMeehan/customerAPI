package com.bah.app.customerapi;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		inMemoryCustomerRepository.addCustomer(newCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newCustomer.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
		
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<?> update(@RequestBody Customer oldCustomer,
			@PathVariable("customerId") long customerId) {
		if (oldCustomer.getId()!=customerId
				|| oldCustomer.getUsername()==null
				|| oldCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		inMemoryCustomerRepository.updateCustomer(oldCustomer);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{customerId")
	public ResponseEntity<?> delete(@RequestBody Customer oldCustomer,
			@PathVariable("customerId") long customerId) {
		if (oldCustomer.getId()!=customerId
				|| oldCustomer.getUsername()==null
				|| oldCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		inMemoryCustomerRepository.deleteCustomer(oldCustomer);
		return ResponseEntity.ok().build();
	}
	
}
