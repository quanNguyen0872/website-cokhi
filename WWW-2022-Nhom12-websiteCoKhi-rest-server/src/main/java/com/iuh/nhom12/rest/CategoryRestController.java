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

import com.iuh.nhom12.entity.Category;
import com.iuh.nhom12.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryRestController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> findAll() {
		return categoryService.findAll();
	}
	
	@GetMapping("/categories/{id}")
	public Category findById(@PathVariable int id) {
		Category category = categoryService.findById(id);
		if (category == null) {
			throw new MyNotFoundException("Category not found - " + id);
		}	
		return category;
	}
	
	@GetMapping("/categories/name/{name}")
	public Category findByName(@PathVariable String name) {
		Category category = categoryService.findByName(name);
		if (category == null) {
			throw new MyNotFoundException("Category not found - " + name);
		}	
		return category;
	}
	
	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category) {
		category.setId(0);
		categoryService.saveCategory(category);
		return category;
	}
	
	@PutMapping("/categories")
	public Category updateCategory(@RequestBody  Category category) {
		categoryService.saveCategory(category);
		return category;
	}
	
	@DeleteMapping("/categories/{id}")
	public String deleteProductType(@PathVariable int id) {
		Category tempCategory = categoryService.findById(id);
		if (tempCategory == null) {
			throw new MyNotFoundException("Category id not found - " + id);
		}
		categoryService.deleteById(id);
		return "Delete category id - " + id;
	}
}
