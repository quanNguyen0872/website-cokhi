/* Author: La Vo Minh Quan
 * 
 * */
package com.iuh.nhom12.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iuh.nhom12.model.Customer;
import com.iuh.nhom12.service.CustomerService;
import com.iuh.nhom12.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	@Autowired
	private UserDetailsManager userDetailsManager;

	@Autowired
	private CustomerService customerService;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	private CrmUser crmUser;

	private Logger logger = Logger.getLogger(getClass().getName());

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model theModel) {

		theModel.addAttribute("crmUser", new CrmUser());

		return "register/registration-form";

	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
			BindingResult theBindingResult, Model theModel) {

		String userName = theCrmUser.getUserName();

		logger.info("Processing registration form for: " + userName);

		// form validation
		if (theBindingResult.hasErrors()) {

			theModel.addAttribute("crmUser", new CrmUser());
			theModel.addAttribute("registrationError", "User name/password can not be empty.");

			logger.warning("User name/password can not be empty.");

			return "register/registration-form";
		}

		// check the database if user already exists
		boolean userExists = doesUserExist(userName);

		if (userExists) {
			theModel.addAttribute("crmUser", new CrmUser());
			theModel.addAttribute("registrationError", "User name already exists.");

			logger.warning("User name already exists.");

			return "register/registration-form";
		}

		crmUser = theCrmUser;

		theModel.addAttribute("customer", new Customer());

		return "register/customer-registration-form";
	}

	@PostMapping("/processCustomerRegistrationForm")
	public String processCustomerForm(@ModelAttribute("customer") @Valid Customer customer, BindingResult theBindingResult, HttpServletRequest request) {

		// process user name & password
		String userName = crmUser.getUserName();

		// encrypt the password
		String encodedPassword = passwordEncoder.encode(crmUser.getPassword());

		// prepend the encoding algorithm id
		encodedPassword = "{bcrypt}" + encodedPassword;

		// give user default role of "employee"
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_CUSTOMER");

		// create user object (from Spring Security framework)
		User tempUser = new User(userName, encodedPassword, authorities);

		if (theBindingResult.hasErrors()) {
			return "register/customer-registration-form";
		} else {
			// save user in the database
			userDetailsManager.createUser(tempUser);
			logger.info("Successfully created user: " + userName);
			// save customer
			customer.setUsername(request.getParameter("username"));
			customerService.saveCustomer(customer);

			// add user and customer successful
			return "register/registration-confirmation";
		}	
	}

	private boolean doesUserExist(String userName) {

		logger.info("Checking if user exists: " + userName);

		// check the database if the user already exists
		boolean exists = userDetailsManager.userExists(userName);

		logger.info("User: " + userName + ", exists: " + exists);

		return exists;
	}
}
