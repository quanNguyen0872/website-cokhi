package com.iuh.nhom12.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.nhom12.dao.OrderDetailDAO;
import com.iuh.nhom12.entity.OrderDetail;
import com.iuh.nhom12.service.OrderDetailService;

/**
 * 
 * @author Nguyen Hong Quan
 *
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Override
	@Transactional
	public List<OrderDetail> findAll() {
		return orderDetailDAO.findAll();
	}

	@Override
	@Transactional
	public OrderDetail findById(int id) {
		return orderDetailDAO.findById(id);
	}

	@Override
	@Transactional
	public void saveOrderDetail(OrderDetail orderDetail) {
		orderDetailDAO.saveOrderDetail(orderDetail);
	}
	
	
	@Override
	@Transactional
	public List<OrderDetail> findAllByOrderId(int orderId){
		return orderDetailDAO.findAllByOrderId(orderId);
	}

	@Override
	@Transactional
	public void deleteOrderDetail(int orderId, int productId) {
		orderDetailDAO.deleteOrderDetail(orderId, productId);
		
	}
}
