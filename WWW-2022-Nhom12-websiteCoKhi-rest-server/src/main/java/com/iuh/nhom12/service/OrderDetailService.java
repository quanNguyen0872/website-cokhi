package com.iuh.nhom12.service;

import java.util.List;

import com.iuh.nhom12.entity.OrderDetail;

/**
 * 
 * @author Nguyen Hong Quan
 *
 */
public interface OrderDetailService {

	public List<OrderDetail> findAll();

	public OrderDetail findById(int id);

	public void saveOrderDetail(OrderDetail orderDetail);

	public List<OrderDetail> findAllByOrderId(int orderId);

	public void deleteOrderDetail(int orderId, int productId);
}
