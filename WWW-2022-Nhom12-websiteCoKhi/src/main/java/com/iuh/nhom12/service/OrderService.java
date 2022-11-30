package com.iuh.nhom12.service;

/**
 * @author Nguyen Hong Quan
 */

import java.util.List;

import com.iuh.nhom12.model.Order;

public interface OrderService {
	public List<Order> findAll();

	public Order findById(int id);

	public void saveOrder(Order order);

	public Order findByCustomerId(int customerId, int status);
	
	public List<Order> findAllByCustomerId(int customerId,int status);

	public void deleteById(int orderId);
}
