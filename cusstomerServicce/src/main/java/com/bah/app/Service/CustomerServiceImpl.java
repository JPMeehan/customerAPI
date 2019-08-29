package com.bah.app.Service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.app.Repository.CustomerRepository;
import com.bah.app.customerapi.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository repo;
	
	

	@Override
	public Iterable<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Customer findCustomerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		repo.save(customer);
		
	}

	@Override
	public Customer findByName(String name) {
		// TODO Auto-generated method stub
		Customer temp = new Customer("","","");
		
		Iterator<Customer> itr =  this.findAllCustomers().iterator();
		
		temp = itr.next();
		
		
		while(itr.hasNext()) {
			if((temp.getUsername().equalsIgnoreCase(name))) {
				temp = itr.next();
			} else {
				continue;
			}
		}
		
		return temp;
	}
}
