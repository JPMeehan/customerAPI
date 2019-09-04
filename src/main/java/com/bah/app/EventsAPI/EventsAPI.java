package com.bah.app.EventsAPI;


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

import com.bah.app.Repository.EventsRepository;
//import com.bah.app.Service.CustomerService;

@RestController
@RequestMapping("/events")
public class EventsAPI {
	
	
	@Autowired
	private EventsRepository repo; 
	
	
	@GetMapping()
	public Iterable<Events> getAllEvents() {
		return repo.findAll();
	}
		
	@GetMapping("/code/{id}")
	public Events getEventbyId(@PathVariable Long eventID) {
		//return customerServiceImpl.findCustomerById(id);
		return repo.findByid(eventID);
	}
	
	@GetMapping("/{title}") 
	public Events getEventbyTitle(@PathVariable String title) {
		//return customerServiceImpl.findByName(name);
		return repo.findBytitle(title);
	}
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Events newEvent, 
			 UriComponentsBuilder uri) {
		if (newEvent.getId()!=0
				|| newEvent.getEventCode() == null
				|| newEvent.getEventDescription() == null
				|| newEvent.getTitle() == null
				) {
			return ResponseEntity.badRequest().build();
		}
		newEvent = repo.save(newEvent);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEvent.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
		
	}
	
	@PutMapping("/{eventID}")
	public ResponseEntity<?> update(@RequestBody Events updateEvent,
			@PathVariable("eventID") String eventID) {
		if (updateEvent.getId()!=0
				|| updateEvent.getEventCode() == null
				|| updateEvent.getEventDescription() == null
				|| updateEvent.getTitle() == null
				)  {
			return ResponseEntity.badRequest().build();
		}
		repo.save(updateEvent);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public void deleteEvent(@PathVariable("id") Long id) {
			repo.deleteById(id);
		}
	}

	
	


