package com.cg.ofd.customer.service;

import java.util.List;
import java.util.Optional;

import com.cg.ofd.customer.entity.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public List<Customer> findAllCustomer();
	public Optional<Customer> findCustomerById(int customerId);
	public void delete(int customerId);
	
}
