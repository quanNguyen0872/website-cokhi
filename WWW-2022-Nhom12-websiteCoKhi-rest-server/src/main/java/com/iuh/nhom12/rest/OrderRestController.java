package com.iuh.nhom12.rest;

import java.util.Date;
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

import com.iuh.nhom12.entity.Order;
import com.iuh.nhom12.service.OrderService;


@RestController
@RequestMapping("/api")
public class OrderRestController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders")
	public List<Order> findAllOrder() {
		return orderService.findAll();
	}
	
	@GetMapping("/orders/{id}")
	public Order findById(@PathVariable int id) {
		Order order = orderService.findById(id);
		if(order == null) {
			throw new MyNotFoundException("Order not found - " + id);
		}
		return order;
	}
	
	@PostMapping("/orders")
	public Order addOrder(@RequestBody Order order) {
		order.setId(0);
		order.setOrderDate(new Date());
		orderService.saveOrder(order);
		return order;
	}
	
	@PutMapping("/orders")
	public Order updateOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
		return order;
	}
	
	@GetMapping("/orders/customers/{customerId}/{status}")
	public Order findByCustomerId(@PathVariable int customerId, @PathVariable int status) {
		Order order = orderService.findByCustomerId(customerId, status);
		if(order == null) {
			throw new MyNotFoundException("Order not found - " + customerId);
		}
		return order;
	}
	
	@GetMapping("/orders/customers/all/{customerId}/{status}")
	public List<Order> findAllByCustomerId(@PathVariable int customerId, @PathVariable int status) {
		List<Order> orders = orderService.findAllByCustomerId(customerId, status);
		return orders;
	}
	
	@DeleteMapping("/orders/{orderId}")
	public void deleteById(@PathVariable int orderId) {
		orderService.deleteById(orderId);
	}
}
