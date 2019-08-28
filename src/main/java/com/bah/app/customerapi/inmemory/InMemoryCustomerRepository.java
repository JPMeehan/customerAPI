package com.bah.app.customerapi.inmemory;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.bah.app.customerapi.Customer;
@Component
public class InMemoryCustomerRepository {
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	
	public ArrayList<Customer> getAllCustomer() {
		return this.customerList;
	}
	
	public void createCustomerList() {
		customerList.add(new Customer("Tom", "t@yahoo.com", "pass1"));
		customerList.add(new Customer("Tommy", "tt@yahoo.com", "pass2"));
		customerList.add(new Customer("Thomas", "tms@yahoo.com", "pass3"));
	}
	
	public Customer getCustomer(int index) {
		return customerList.get(0);
	}
}
