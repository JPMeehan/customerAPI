package com.bah.app.Service;

import com.bah.app.customerapi.Customer;

public interface CustomerService {
	public Iterable<Customer> findAllCustomers();
	public Customer findCustomerById(Long id);
	public void saveCustomer(Customer customer);
	public Customer findByName(String name);
}
