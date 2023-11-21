package com.valtech.training.invoiceassignment.components;

import java.util.List;

public interface CustomerDAO {

	long count();

	void createCustomer(Customer cust);

	void deleteCustomer(int custId);

	void updateCustomer(Customer cust);

	List<Customer> getAllCustomers();

	Customer getCustomers(int custId);

}