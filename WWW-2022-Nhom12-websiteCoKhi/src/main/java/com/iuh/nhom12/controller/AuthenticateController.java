/* Author: La Vo Minh Quan
 * 
 * */
package com.iuh.nhom12.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iuh.nhom12.model.Customer;
import com.iuh.nhom12.model.Email;
import com.iuh.nhom12.service.CustomerService;
import com.iuh.nhom12.util.EmailUtils;
import com.iuh.nhom12.util.UserUtils;

@Controller
public class AuthenticateController {
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "page/login-page";
	}
	
	@GetMapping("/showForgotPasswordPage")
	public String showMyForgotPasswordPage() {
		return "page/forgot_password-page";
	}
	
	@PostMapping("/processForgotPassword")
	public String processForgotPassword(@RequestParam("userName") String username, @RequestParam("email") String emailAddress, Model model) {
		
		try {
			
			if (customerService.findByUsernameAndEmail(username, emailAddress) == null) {
				model.addAttribute("error", "username or email are incorrect");
				return "page/forgot_password-page";
			} else {
//				Customer customer = customerService.findByUsernameAndEmail(username, emailAddress);
//				User user = (User) userDetailsManager.loadUserByUsername(customer.getUsername());
				
				String newPassword = "password1234";
				
				String encodedPassword = passwordEncoder.encode(newPassword);
				encodedPassword = "{bcrypt}" + encodedPassword;
				List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_CUSTOMER");
				User tempUser = new User(username, encodedPassword, authorities);	
				userDetailsManager.updateUser(tempUser);
				
				Email theEmail = new Email();
				theEmail.setFrom("nhom12www@gmail.com");
				theEmail.setFromPassword("Test1234@");
				theEmail.setTo(emailAddress);
				theEmail.setSubject("Forgot password function");
				
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username).append("<br />");
				sb.append("You are used the forgot password Function.class <br />");
				sb.append("Your password is <b>").append(newPassword).append("<b/> <br/>");
				sb.append("Regards<br/>");
				sb.append("Administrator");
				
				theEmail.setContent(sb.toString());
				EmailUtils.send(theEmail);
				
				model.addAttribute("message", "Email sent to the email address. " + " Please check and get your password.");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
		}
		
		return "page/forgot_password-confirm";
	}
	
	@GetMapping("/showResetPasswordForm")
	public String showResetPassword() {
		return "customer/reset-password-form";
	}
	
	@PostMapping("/processResetPassword")
	public String processResetPassword(@RequestParam("password") String newPassword, @RequestParam("repeatPassword") String repeatPassword, Model model) {
		Customer customer = customerService.findByUsername(UserUtils.getUserName());
		User user = (User) userDetailsManager.loadUserByUsername(customer.getUsername());
		
		if (newPassword.equals(repeatPassword)) {
			String encodedPassword = passwordEncoder.encode(newPassword);
			encodedPassword = "{bcrypt}" + encodedPassword;
			userDetailsManager.changePassword(user.getPassword(), encodedPassword);
		} else {
			model.addAttribute("error", "password not same!");
		    return "customer/reset-password-form";
		}
			
		return "redirect:/showInfomationUserPage";
	}
}
