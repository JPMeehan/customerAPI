package com.bah.app.Repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.app.RegistrationAPI.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Long>{
	public Registration findBycustomerID(Long customerID);		
	public Registration findByid(Long id);
	
}
