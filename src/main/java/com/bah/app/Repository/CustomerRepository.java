package com.bah.app.Repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.app.customerAPI.Events;

public interface CustomerRepository extends CrudRepository<Events, Long>{
	public Events findByusername(String username);		
	public Events findByid(Long id);
	
}
