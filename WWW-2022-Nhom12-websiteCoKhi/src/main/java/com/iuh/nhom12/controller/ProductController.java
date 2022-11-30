package com.iuh.nhom12.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.iuh.nhom12.model.Category;
import com.iuh.nhom12.model.Product;
import com.iuh.nhom12.service.CategoryService;
import com.iuh.nhom12.service.ProductService;

@Controller
@RequestMapping("/manager/product")
public class ProductController {

	@Autowired
	public ProductService productService;

	@Autowired
	public CategoryService categoryService;

	@ModelAttribute("listOfCategories")
	public List<String> loadCaterogy(Model model) {
		List<Category> categories = categoryService.findAll();
		List<String> listOfCategories = new ArrayList<>();
		for (Category category : categories) {
			listOfCategories.add(category.getCategoryName());
		}
		return listOfCategories;
	}

	@GetMapping("/list")
	public String getProducts(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "manager/product/list-products";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "manager/product/product-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "manager/product/product-form";
	}

	@RequestMapping(path = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile fileImage)
			throws IOException {

		// Save file on system
		if (!fileImage.getOriginalFilename().isEmpty()) {
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(new File("C:\\Users\\PC\\Documents\\WWW\\Nhom12_WWW_ver2\\WWW-2022-Nhom12-websiteCoKhi\\src\\main\\webapp\\resources\\uploads", fileImage.getOriginalFilename())));
			outputStream.write(fileImage.getBytes());
			outputStream.flush();
			outputStream.close();
			System.out.println(fileImage.getOriginalFilename());
			product.setImage(fileImage.getOriginalFilename());
		} else {
			System.out.println("File invalid!");
		}

		Category category = categoryService.findByName(product.getCategoryName());

		product.setCategory(category);

		System.out.println(product.getName());

		productService.saveProduct(product);

		return "redirect:/manager/product/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("productId") int id) {
		productService.deleteById(id);
		return "redirect:/manager/product/list";
	}
}
