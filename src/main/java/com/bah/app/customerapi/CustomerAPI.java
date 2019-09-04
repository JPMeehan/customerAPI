package com.bah.app.customerAPI;

import java.net.URI;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.bah.app.Repository.CustomerRepository;
//import com.bah.app.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerAPI {
	
	
	@Autowired
	private CustomerRepository repo; 
	
	
	@GetMapping()
	public Iterable<Events> getAllCustomers() {
		return repo.findAll();
	}
		
	@GetMapping("/user/{id}")
	public Events getCustomerbyId(@PathVariable long id) {
		//return customerServiceImpl.findCustomerById(id);
		return repo.findByid(id);
	}
	
	@GetMapping("/{name}") 
	public Events getCustomerbyName(@PathVariable String name) {
		//return customerServiceImpl.findByName(name);
		return repo.findByusername(name);
	}
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Events newCustomer, 
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
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Events updateCustomer,
			@PathVariable("id") long iD) {
		if (updateCustomer.getId()!= iD
				|| updateCustomer.getUsername()==null
				|| updateCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		repo.save(updateCustomer);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable("id") Long id) {
			repo.deleteById(id);
		}
	}

	
	

