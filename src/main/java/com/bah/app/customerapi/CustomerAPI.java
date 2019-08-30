package com.bah.app.customerapi;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.app.Repository.CustomerRepository;
//import com.bah.app.Service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerAPI {
	
	
	@Autowired
	private CustomerRepository repo; 
	
	
	@GetMapping()
	public Iterable<Customer> getAllCustomers() {
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Customer> getCustomerbyId(@PathVariable long id) {
		//return customerServiceImpl.findCustomerById(id);
		return repo.findById(id);
	}
	
	@GetMapping("/{name}") 
	public Customer getCustomerbyName(@PathVariable String name) {
		//return customerServiceImpl.findByName(name);
		return repo.findByUsername(name);
	}
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Customer newCustomer, 
			 UriComponentsBuilder uri) {
		if (newCustomer.getId()!=0
				|| newCustomer.getUsername()==null
				|| newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer = repo.save(newCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCustomer.getId()).toUri();
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
		repo.save(oldCustomer);
		return ResponseEntity.ok().build();
	}
	
	
	
	
}
