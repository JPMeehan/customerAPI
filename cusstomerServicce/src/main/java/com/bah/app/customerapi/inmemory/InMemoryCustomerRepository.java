package com.bah.app.customerapi.inmemory;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.bah.app.customerapi.Customer;
@Component
public class InMemoryCustomerRepository {
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	
	public InMemoryCustomerRepository() {
		this.createCustomerList();
	}
	
	

	
	public void createCustomerList() {
		customerList.add(new Customer("Tom", "t@yahoo.com", "pass1"));
		customerList.add(new Customer("Tommy", "tt@yahoo.com", "pass2"));
		customerList.add(new Customer("Thomas", "tms@yahoo.com", "pass3"));
	}
	
	
	public Customer getCustomer(String name) {
		Customer temp = new Customer("","","");
		
		
		for (int i = 0; i < this.customerList.size(); i++) {
			if(this.customerList.get(i).getUsername().equalsIgnoreCase(name)) {
				temp = this.customerList.get(i);
			}
		}
			return temp;
		}
		
	public ArrayList<Customer> getAllCustomers() {
		return this.customerList;
	}
}
