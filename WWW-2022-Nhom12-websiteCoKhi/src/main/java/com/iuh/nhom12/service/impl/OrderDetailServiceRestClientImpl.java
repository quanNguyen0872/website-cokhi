package com.iuh.nhom12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iuh.nhom12.model.OrderDetail;
import com.iuh.nhom12.service.OrderDetailService;

/**
 * @author Nguyen Hong Quan
 */
@Service
public class OrderDetailServiceRestClientImpl implements OrderDetailService {

	private RestTemplate restTemplate;
	private String crmRestUrl;

	public OrderDetailServiceRestClientImpl(RestTemplate theRestTemplate,
			@Value("${orderDetails.crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
	}

	@Override
	public List<OrderDetail> findAll() {
		ResponseEntity<List<OrderDetail>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<OrderDetail>>() {
				});
		List<OrderDetail> orderDetails = responseEntity.getBody();
		return orderDetails;
	}

	@Override
	public OrderDetail findById(int id) {
		OrderDetail theOrderDetail = restTemplate.getForObject(crmRestUrl + "/" + id, OrderDetail.class);
		return theOrderDetail;
	}

	@Override
	public void saveOrderDetail(OrderDetail orderDetail) {
		restTemplate.postForEntity(crmRestUrl, orderDetail, String.class);
	}

	@Override
	public List<OrderDetail> findAllByOrderId(int orderId) {
		ResponseEntity<List<OrderDetail>> responseEntity = restTemplate.exchange(crmRestUrl + "/orders/" + orderId,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<OrderDetail>>() {
				});
		List<OrderDetail> orderDetails = responseEntity.getBody();
		return orderDetails;
	}

	@Override
	public void deleteOrderDetail(int orderId, int productId) {
		restTemplate.delete(crmRestUrl + "/orderDetail/" + orderId + "/" + productId);
	}

}
