package com.iuh.nhom12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iuh.nhom12.model.Category;
import com.iuh.nhom12.service.CategoryService;

@Controller
@RequestMapping("/manager/category")
public class CategoryController {

	@Autowired
	public CategoryService categoryService;

	@GetMapping("/list")
	public String getCategories(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "manager/category/list-categories";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "manager/category/category-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("categoryId") int id, Model model) {
		Category category = categoryService.findById(id);
		model.addAttribute("category", category);
		return "manager/category/category-form";
	}

	@PostMapping("/saveCategoty")
	public String saveCategory(@ModelAttribute("category") Category category) {

		categoryService.saveCategory(category);

		return "redirect:/manager/category/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("categoryId") int id) {
		categoryService.deleteById(id);
		return "redirect:/manager/category/list";
	}
}
