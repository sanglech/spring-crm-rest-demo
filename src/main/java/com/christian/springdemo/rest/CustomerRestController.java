package com.christian.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christian.springdemo.entity.Customer;
import com.christian.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	// autowire the customer service
	@Autowired
	private CustomerService customerService;
	
	
	//add mapping for get /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
		}
	
	@GetMapping("/customer/{customerid}")
	public Customer getCustomer(@PathVariable int customerid) {
		
		return customerService.getCustomer(customerid);
	}
}
