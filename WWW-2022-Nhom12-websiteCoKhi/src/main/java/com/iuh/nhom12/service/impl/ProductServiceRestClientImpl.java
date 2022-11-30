/* Author: Doan Thi My Linh
 * 
 * */
package com.iuh.nhom12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iuh.nhom12.model.Product;
import com.iuh.nhom12.service.ProductService;

@Service
public class ProductServiceRestClientImpl implements ProductService {

	private RestTemplate restTemplate;
	private String crmRestUrl;

	public ProductServiceRestClientImpl(RestTemplate theRestTemplate,
			@Value("${products.crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
	}

	@Override
	public List<Product> findAll() {
		ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
				});

		// get list products from response
		List<Product> products = responseEntity.getBody();

		return products;
	}

	@Override
	public Product findById(int id) {
		Product theProduct = restTemplate.getForObject(crmRestUrl + "/" + id, Product.class);
		return theProduct;
	}

	@Override
	public void saveProduct(Product product) {
		int productId = product.getId();
		// productId auto generate, if productId == 0 ==> product not create ==> add
		// product
		if (productId == 0) {
			// add product
			// make rest call
			restTemplate.postForEntity(crmRestUrl, product, String.class);
		} else {
			// update product
			// make rest call
			restTemplate.put(crmRestUrl, product);
		}

	}

	@Override
	public void deleteById(int id) {
		restTemplate.delete(crmRestUrl + "/" + id);
	}

}
