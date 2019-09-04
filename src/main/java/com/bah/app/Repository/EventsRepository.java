package com.bah.app.Repository;


import org.springframework.data.repository.CrudRepository;

import com.bah.app.EventsAPI.Events;


public interface EventsRepository extends CrudRepository<Events, Long>{
	public Events findByid(Long id);		
	public Events findBytitle(String title);
	
}