package com.dms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dms.model.CustomerDTO;
import com.dms.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@Validated
public class CustomerController {

	// It is use for automatic dependency injection.
	// This means that Spring will automatically inject the required dependencies
	// into a bean,without the need for manual configuration
	@Autowired
	CustomerService customerService;

	// It is to send the data in database or save information
	@PostMapping("/api/addCustomer")
	ResponseEntity<CustomerDTO> addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		return new ResponseEntity<CustomerDTO>(customerService.addCustomer(customerDTO),HttpStatus.CREATED);
	}

	// Get All Customer Information
	@GetMapping("/api/getAllCustomers")
	List<CustomerDTO> getAllCustomers() {
		return customerService.getAllCustomers();

	}

	// Get One Customer Information
	@GetMapping("/api/getCustomerById/{id}")
	CustomerDTO getCustomerById(@Valid @PathVariable("id") int id) {
		return customerService.getCustomerById(id);

	}
	
	//Update information according to there id
	@PutMapping("/api/updateCustomerById/{id}")
	CustomerDTO updateCustomerById(@Valid @RequestBody CustomerDTO customerDTO,@Valid @PathVariable("id") int id) {
		return customerService.updateCustomer(customerDTO, id);
	}
	
	//Delete Customer by there id
	@DeleteMapping("/api/deleteCustomerById/{id}")
	String deleteCustomerById(@Valid @PathVariable("id") int id) {
		return customerService.deleteCustomerById(id);
	}
}
