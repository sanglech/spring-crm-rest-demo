package com.christian.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		Customer theCustomer = customerService.getCustomer(customerid);
		
		if(theCustomer==null) {
			throw new CustomerNotFoundException ("Customer with id "+ customerid+ " was not found.");
		}
		return theCustomer;
	}
	
	//add mapping for POSt / customers
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		//also just in case pass an id of 0
		//this is a force a save of new items
		theCustomer.setId(0);
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
}
