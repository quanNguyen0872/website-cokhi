/* Author: La Vo Minh Quan
 * 
 * */
package com.iuh.nhom12.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.nhom12.entity.Customer;
import com.iuh.nhom12.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerService.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customer findById(@PathVariable int id) {
		Customer customer = customerService.findById(id);
		if (customer == null) {
			throw new MyNotFoundException("Customer not found - " + id);
		}	
		return customer;
	}
	
	@GetMapping("/customers/customer/{username}/{email}/")
	public Customer findByUsernameAndEmail(@PathVariable String username, @PathVariable String email) {
		System.out.println(username + " - " + email);
		Customer customer = customerService.findByUsernameAndEmail(username, email);
		if (customer == null) {
			throw new MyNotFoundException("Customer not found - " + username + " and " + email);
		}	
		return customer;
	}
	
	@GetMapping("/customers/customer/{userName}")
	public Customer findByUser(@PathVariable String userName) {
		Customer customer = customerService.findByUser(userName);
		if (customer == null) {
			throw new MyNotFoundException("Customer not found - " + userName);
		}	
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer addUserInfo(@RequestBody Customer customer) {
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateUserInfo(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteUserInfo(@PathVariable int id) {
		Customer tempCustomer = customerService.findById(id);
		if (tempCustomer == null) {
			throw new MyNotFoundException("Customer id not found - " + id);
		}
		customerService.deleteById(id);
		return "Delete customer id - " + id;
	}
}
