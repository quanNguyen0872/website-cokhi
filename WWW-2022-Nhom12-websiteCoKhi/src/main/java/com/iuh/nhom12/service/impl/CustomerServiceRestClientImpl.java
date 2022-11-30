/* Author: La Vo Minh Quan
 * 
 * */
package com.iuh.nhom12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iuh.nhom12.model.Customer;
import com.iuh.nhom12.service.CustomerService;

@Service
public class CustomerServiceRestClientImpl implements CustomerService {

	private RestTemplate restTemplate;
	private String crmRestUrl;

	@Autowired
	public CustomerServiceRestClientImpl(RestTemplate theRestTemplate,
			@Value("${customers.crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
	}

	@Override
	public List<Customer> findAll() {
		// make rest call
		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {
				});

		// get list customers from response
		List<Customer> customers = responseEntity.getBody();

		return customers;
	}

	@Override
	public Customer findById(int id) {
		Customer theCustomer = restTemplate.getForObject(crmRestUrl + "/" + id, Customer.class);
		return theCustomer;
	}
	
	@Override
	public Customer findByUsernameAndEmail(String userName, String email) {
		Customer theCustomer;
		try {
			theCustomer = restTemplate.getForObject(crmRestUrl + "/customer/" + userName + "/" + email + "/", Customer.class);
		} catch (Exception e) {
			e.printStackTrace();
			theCustomer = null;
		}
		return theCustomer;
	}
	
	@Override
	public Customer findByUsername(String userName) {
		Customer theCustomer = restTemplate.getForObject(crmRestUrl + "/customer/" + userName, Customer.class);
		return theCustomer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		int customerId = customer.getId();
		// customerId auto generate, if customerId == 0 ==> customer not create ==> add
		// customer
		if (customerId == 0) {
			// add customer
			// make rest call
			restTemplate.postForEntity(crmRestUrl, customer, String.class);
		} else {
			// update customer
			// make rest call
			restTemplate.put(crmRestUrl, customer);
		}
	}

	@Override
	public void deleteById(int id) {
		restTemplate.delete(crmRestUrl + "/" + id);
	}

}
