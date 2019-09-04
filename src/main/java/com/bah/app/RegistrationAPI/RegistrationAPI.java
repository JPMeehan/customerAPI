package com.bah.app.RegistrationAPI;



import java.net.URI;

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

import com.bah.app.Repository.RegistrationRepository;

@RestController
@RequestMapping("/registration")
public class RegistrationAPI {
	
	
	@Autowired
	private RegistrationRepository repo; 
	
	
	@GetMapping()
	public Iterable<Registration> getAllRegistrations() {
		return repo.findAll();
	}
		
	@GetMapping("/code/{eventID}")
	public Registration getEventbyId(@PathVariable Long eventID) {
		//return customerServiceImpl.findCustomerById(id);
		return repo.findByid(eventID);
	}
	
	@GetMapping("/customer/{customerID}") 
	public Registration getEventbyCustomerID(@PathVariable Long customerID) {
		//return customerServiceImpl.findByName(name);
		return repo.findBycustomerID(customerID);
	}
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Registration newRegistration, 
			 UriComponentsBuilder uri) {
		if (newRegistration.getId()!=0
				|| newRegistration.getCustomerID() == null
				|| newRegistration.getEventID() == null
				|| newRegistration.getNotes() == null
				|| newRegistration.getRegistrationDate() == null
				) {
			return ResponseEntity.badRequest().build();
		}
		newRegistration = repo.save(newRegistration);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newRegistration.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
		
	}
	
	@PutMapping("/{eventID}")
	public ResponseEntity<?> update(@RequestBody Registration newRegistration,
			@PathVariable("id") String eventID) {
		if (newRegistration.getId()!=0
				|| newRegistration.getCustomerID() == null
				|| newRegistration.getEventID() == null
				|| newRegistration.getNotes() == null
				|| newRegistration.getRegistrationDate() == null
				)  {
			return ResponseEntity.badRequest().build();
		}
		repo.save(newRegistration);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public void deleteEvent(@PathVariable("id") Long id) {
			repo.deleteById(id);
		}
	}

	
	



