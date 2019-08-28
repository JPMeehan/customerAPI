package com.bah.customer.Repository;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component 
public class InMemoryCustomerRepository {
	ArrayList<Customer> customers;
	
	public ArrayList<Customer> getAllCustomers() {
		return customers;
	}
	
	public InMemoryCustomerRepository() {
		setCustomers();

	}
	
	public void setCustomers() {
		this.customers = new ArrayList<Customer>();
		customers.add(new Customer("frank","f@yahoo.com", "pass1"));
		customers.add(new Customer("frankie","fee@yahoo.com", "pass12"));
		customers.add(new Customer("frankfortt","f12@yahoo.com", "pass13"));
	}
	
	public Customer getCustomer(String name) {
		Customer temp = null;
		for(Customer cus: customers) {
			temp = (cus.getName().equalsIgnoreCase(name)) ? cus : null;
		}
		return temp;
	}
}
