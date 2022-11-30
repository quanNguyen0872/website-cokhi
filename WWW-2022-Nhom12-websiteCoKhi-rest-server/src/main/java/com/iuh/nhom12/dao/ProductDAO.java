/* Author: Doan Thi My Linh
 * 
 * */
package com.iuh.nhom12.dao;

import java.util.List;

import com.iuh.nhom12.entity.Product;

public interface ProductDAO {
	public List<Product> findAll();

	public Product findById(int id);

	public void saveProduct(Product product);

	public void deleteById(int id);
}
