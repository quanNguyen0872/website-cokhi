/* Author: La Vo Minh Quan
 * 
 * */
package com.iuh.nhom12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.iuh.nhom12.model.Customer;
import com.iuh.nhom12.model.Product;
import com.iuh.nhom12.service.CustomerService;
import com.iuh.nhom12.service.ProductService;
import com.iuh.nhom12.util.UserUtils;


@Controller
public class HomeController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String showHomePage(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "page/home-page";
	}
	
	@GetMapping("/showRecommendPage")
	public String showRecommentPage() {
		return "page/recommend-page";
	}
	
	@GetMapping("/showInfomationUserPage")
	public String showInfomationUserPage(Model model) {
		Customer customer = customerService.findByUsername(UserUtils.getUserName());
		model.addAttribute("customer", customer);
		return "customer/infomation-user-page";
	}
	
	@GetMapping("/infomationUserForm")
	public String infomationUserForm(Model model) {
		Customer customer = customerService.findByUsername(UserUtils.getUserName());
		model.addAttribute("customer", customer);
		return "customer/infomation-form";
	}
	
	@PostMapping("/processUpdateUserInfo")
	public String processUpdateUserInfo(@ModelAttribute("customer") Customer customer) {
		customer.setUsername(UserUtils.getUserName());
		customerService.saveCustomer(customer);
		return "customer/infomation-user-page";
	}

}
