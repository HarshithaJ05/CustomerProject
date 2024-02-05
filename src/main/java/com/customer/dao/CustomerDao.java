package com.customer.dao;

import java.util.List;

import com.customer.module.Customer;

public interface CustomerDao {

	int addCustomer(Customer customer);
	int updateCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer getCustomerById(String customerId);
	int deleteCustomer(String customerId);
	int getAllCustomerCount();
	 List<Customer> getCustomerByFirstName(String firstName);
	 List<Customer> getCustomerByEmail(String email);
	 List<Customer> getCustomerByCity(String city);
	 List<Customer> getCustomerByPhone(String phoneNumber);
	 List<Customer> getCustomersWithPagination(int start, int recordsPerPage);
	
	
	
}
