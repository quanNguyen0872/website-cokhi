/* Author: Doan Thi My Linh
 * 
 * */
package com.iuh.nhom12.rest;

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

import com.iuh.nhom12.entity.Product;
import com.iuh.nhom12.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> findAll() {
		return productService.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product findById(@PathVariable int id) {
		Product product = productService.findById(id);
		if (product == null) {
			throw new MyNotFoundException("Product not found - " + id);
		}	
		return product;
	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		product.setId(0);
		productService.saveProduct(product);
		return product;
	}
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody  Product product) {
		productService.saveProduct(product);
		return product;
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		Product tempProduct = productService.findById(id);
		if (tempProduct == null) {
			throw new MyNotFoundException("Product id not found - " + id);
		}
		productService.deleteById(id);
		return "Delete Product id - " + id;
	}
}
