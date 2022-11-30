/* Author: Doan Thi My Linh
 * 
 * */
package com.iuh.nhom12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iuh.nhom12.model.Category;
import com.iuh.nhom12.service.CategoryService;

@Service
public class CategoryServiceRestClientImpl implements CategoryService {

	private RestTemplate restTemplate;
	private String crmRestUrl;

	@Autowired
	public CategoryServiceRestClientImpl(RestTemplate theRestTemplate,
			@Value("${categories.crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
	}

	@Override
	public List<Category> findAll() {
		// make rest call
		ResponseEntity<List<Category>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Category>>() {
				});

		// get list categories from response
		List<Category> categories = responseEntity.getBody();

		return categories;
	}

	@Override
	public Category findById(int id) {
		// make rest call
		// crmRestUrl + theId = json category in server return
		Category theCategory = restTemplate.getForObject(crmRestUrl + "/" + id, Category.class);

		return theCategory;
	}

	@Override
	public void saveCategory(Category category) {
		int categoryId = category.getId();
		// categoryId auto generate, if categoryId == 0 ==> category not create ==> add
		// category
		if (categoryId == 0) {
			// add category
			// make rest call
			restTemplate.postForEntity(crmRestUrl, category, String.class);
		} else {
			// update category
			// make rest call
			restTemplate.put(crmRestUrl, category);
		}
	}

	@Override
	public void deleteById(int id) {
		// make rest call
		restTemplate.delete(crmRestUrl + "/" + id);
	}

	@Override
	public Category findByName(String name) {
		// make rest call
		// crmRestUrl + theId = json category in server return
		Category theCategory = restTemplate.getForObject(crmRestUrl + "/name/" + name, Category.class);

		return theCategory;
	}

}
