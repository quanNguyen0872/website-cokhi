/* Author: Doan Thi My Linh
 * 
 * */
package com.iuh.nhom12.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.nhom12.dao.CategoryDAO;
import com.iuh.nhom12.entity.Category;
import com.iuh.nhom12.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	@Transactional
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	@Transactional
	public Category findById(int id) {
		return categoryDAO.findById(id);
	}

	@Override
	@Transactional
	public void saveCategory(Category category) {
		categoryDAO.saveCategory(category);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		categoryDAO.deleteById(id);
	}

	@Override
	@Transactional
	public Category findByName(String name) {
		return categoryDAO.findByName(name);
	}

}
