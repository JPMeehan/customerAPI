package com.bah.app.Repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.app.customerAPI.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	public Customer findByusername(String username);		
	public Customer findByid(Long id);
	
}
