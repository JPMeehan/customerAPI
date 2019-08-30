package com.bah.app.Repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.app.customerapi.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	public Customer findByUsername(String userName);
		
	
}
