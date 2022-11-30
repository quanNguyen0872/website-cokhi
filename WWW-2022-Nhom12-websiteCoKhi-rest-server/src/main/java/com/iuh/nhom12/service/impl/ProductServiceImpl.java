/* Author: Doan Thi My Linh
 * 
 * */
package com.iuh.nhom12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iuh.nhom12.dao.ProductDAO;
import com.iuh.nhom12.entity.Product;
import com.iuh.nhom12.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public List<Product> findAll() {
		return productDAO.findAll();
	}

	@Override
	@Transactional
	public Product findById(int id) {
		return productDAO.findById(id);
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
		productDAO.saveProduct(product);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		productDAO.deleteById(id);

	}

}
