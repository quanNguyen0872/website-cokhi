package com.iuh.nhom12.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.nhom12.dao.OrderDAO;
import com.iuh.nhom12.entity.Order;
import com.iuh.nhom12.service.OrderService;

/*
 * Author: Nguyen Hong Quan
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	@Transactional
	public List<Order> findAll() {
		return orderDAO.findAll();
	}

	@Override
	@Transactional
	public Order findById(int id) {
		return orderDAO.findById(id);
	}

	@Override
	@Transactional
	public void saveOrder(Order order) {
		orderDAO.saveOrder(order);
	}
	
	@Override
	@Transactional
	public void deleteById(int orderId) {
		orderDAO.deleteById(orderId);
	}

	@Override
	@Transactional
	public Order findByCustomerId(int customerId, int status) {
		return orderDAO.findByCustomerId(customerId, status);
	}

	@Override
	@Transactional
	public List<Order> findAllByCustomerId(int customerId, int status) {
		return orderDAO.findAllByCustomerId(customerId, status);
	}

}
