package com.iuh.nhom12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iuh.nhom12.model.Order;
import com.iuh.nhom12.service.OrderService;

/**
 * @author Nguyen Hong Quan
 */
@Service
public class OrderServiceRestClientImpl implements OrderService {

	private RestTemplate restTemplate;
	private String crmRestUrl;

	public OrderServiceRestClientImpl(RestTemplate theRestTemplate, @Value("${orders.crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
	}

	@Override
	public List<Order> findAll() {
		ResponseEntity<List<Order>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Order>>() {
				});

		List<Order> orders = responseEntity.getBody();

		return orders;
	}

	@Override
	public Order findById(int id) {
		Order theOrder = restTemplate.getForObject(crmRestUrl + "/" + id, Order.class);
		return theOrder;
	}

	@Override
	public void saveOrder(Order order) {
		int orderId = order.getId();
		if (orderId == 0) {
			restTemplate.postForEntity(crmRestUrl, order, String.class);
		} else {
			restTemplate.put(crmRestUrl, order);
		}
	}

	@Override
	public Order findByCustomerId(int customerId, int status) {
		Order theOrder;
		try {
			theOrder = restTemplate.getForObject(crmRestUrl + "/customers/" + customerId + "/" + status, Order.class);
		} catch (Exception e) {
			theOrder = null;
			e.printStackTrace();
		}
		return theOrder;
	}

	@Override
	public void deleteById(int orderId) {
		restTemplate.delete(crmRestUrl + "/" + orderId);
	}

	@Override
	public List<Order> findAllByCustomerId(int customerId, int status) {
		ResponseEntity<List<Order>> responseEntity = restTemplate.exchange(crmRestUrl + "/customers/all/" + customerId + "/" + status, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Order>>() {
				});

		List<Order> orders = responseEntity.getBody();

		return orders;
	}

}
