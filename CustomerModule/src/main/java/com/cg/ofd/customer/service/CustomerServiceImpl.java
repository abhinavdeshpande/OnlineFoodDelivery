package com.cg.ofd.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofd.customer.dao.CustomerRepository;
import com.cg.ofd.customer.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAllCustomer() {
		return this.customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findCustomerById(int customerId) {
		return this.customerRepository.findById(customerId);
	}

	@Override
	public void delete(int customerId) {
		this.customerRepository.deleteById(customerId);

	}

}
