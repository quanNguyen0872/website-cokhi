/* Author: La Vo Minh Quan
 * 
 * */
package com.iuh.nhom12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iuh.nhom12.dao.CustomerDAO;
import com.iuh.nhom12.entity.Customer;
import com.iuh.nhom12.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int id) {
		return customerDAO.findById(id);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		customerDAO.deleteById(id);
	}

	@Override
	@Transactional
	public Customer findByUsernameAndEmail(String userName, String email) {
		Customer customer;
		try {
			customer = customerDAO.findByUsernameAndEmail(userName, email);
		} catch (Exception e) {
			e.printStackTrace();
			customer = null;
		}
		return customer;
	}

	@Override
	@Transactional
	public Customer findByUser(String userName) {
		return customerDAO.findByUser(userName);
	}
}
