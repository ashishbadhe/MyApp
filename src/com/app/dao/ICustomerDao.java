package com.app.dao;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerDao {
	public String saveCustomer(Customer cust);
	public void updateCustomer(Customer cust);
	public void deleteCustomer(String custId);
	public Customer getCustomerById(String custId);
	public List<Customer> getAllCustomers();
	public List<Object[]> getCustomerTypeCount();
	
	public Customer getCustomerByEmail(String email);
}
