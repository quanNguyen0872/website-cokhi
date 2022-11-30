package com.iuh.nhom12.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author La Vo Minh Quan
 * @version 1.0
 * @created 21-Apr-2022 4:45:34 PM
 */
public class Customer {

	private int id;
	
	@NotNull(message = "is required")
	@Size(min=1, message="is required")
	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min=1, message="is required")
	private String lastName;

	private String username;
	
	@NotBlank
    @Email(message = "Please enter a valid e-mail address")
	private String email;
	
	@NotNull(message = "is required")
	@Size(min=1, message="is required")
	private String address;
	
	@NotNull(message = "is required")
	@Size(min=1, message="is required")
	@Pattern(regexp="(^$|[0-9]{10})",message = "must enter a valid phone number")
	private String phoneNumber;

	public Customer() {

	}

	public Customer(String firstName, String lastName, String username, String email, String address,
			String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

//	public Set<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Set<Order> orders) {
//		this.orders = orders;
//	}

}// end UserInfo