package com.dms.service;

import java.util.List;

import com.dms.model.CustomerDTO;

public interface CustomerService {
	
	CustomerDTO addCustomer(CustomerDTO customerDTO);
	List<CustomerDTO> getAllCustomers();
	CustomerDTO getCustomerById(int id);
	CustomerDTO updateCustomer(CustomerDTO customer,int id);
	String deleteCustomerById(int id);
	
}
