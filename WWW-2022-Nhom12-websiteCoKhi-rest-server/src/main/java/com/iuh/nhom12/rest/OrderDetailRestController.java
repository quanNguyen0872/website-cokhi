package com.iuh.nhom12.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.nhom12.entity.OrderDetail;
import com.iuh.nhom12.service.OrderDetailService;

/**
 * 
 * @author Nguyen Hong Quan
 *
 */
@RestController
@RequestMapping("/api")
public class OrderDetailRestController {
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@GetMapping("/orderDetails")
	public List<OrderDetail> findAll() {
		return orderDetailService.findAll();
	}
	
	@GetMapping("/orderDetails/{id}")
	public OrderDetail findById(@PathVariable int id) {
		OrderDetail orderDetail = orderDetailService.findById(id);
		if(orderDetail == null) {
			throw new MyNotFoundException("Order Detail not found - " + id);
		}
		return orderDetail;
	}
	
	@PostMapping("/orderDetails")
	public OrderDetail addOrderDetail(@RequestBody OrderDetail orderDetail) {
		orderDetailService.saveOrderDetail(orderDetail);
		return orderDetail;
	}
	
	@GetMapping("/orderDetails/orders/{orderId}")
	public List<OrderDetail> findAllByOrderId(@PathVariable int orderId) {
		List<OrderDetail> orderDetails = orderDetailService.findAllByOrderId(orderId);
		if(orderDetails == null) {
			throw new MyNotFoundException("Order Detail not found - " + orderId);
		}
		return orderDetails;
	}
	
	@DeleteMapping("/orderDetails/orderDetail/{orderId}/{productId}")
	public String deleteOrderDetail(@PathVariable int orderId, @PathVariable int productId) {
		orderDetailService.deleteOrderDetail(orderId, productId);
		return "Delete successful OrderDetail";
	}
}
