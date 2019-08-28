package com.bah.customer.Repository;
<<<<<<< HEAD
=======

>>>>>>> cec676973f800877acf4169304a97a0b6b2b0c24
import java.util.ArrayList;

import org.springframework.stereotype.Component;

<<<<<<< HEAD
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
=======
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
			if(this.customerList.get(i).getName().equalsIgnoreCase(name)) {
				temp = this.customerList.get(i);
			}
		}
			return temp;
		}
		
	public ArrayList<Customer> getAllCustomers() {
		return this.customerList;
>>>>>>> cec676973f800877acf4169304a97a0b6b2b0c24
	}
}
