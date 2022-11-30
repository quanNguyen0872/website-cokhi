package com.iuh.nhom12.model;

import java.util.Date;

/**
 * @author La Vo Minh Quan
 * @version 1.0
 * @created 21-Apr-2022 4:45:31 PM
 */
public class Order {

	private int id;

	private Date orderDate;

	private String addressDelivery;
	
	private int status;

	private Customer customer;
	
	private double total;

	public Order() {

	}

	public Order(String addressDelivery, Customer customer) {
		super();
		this.addressDelivery = addressDelivery;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getAddressDelivery() {
		return addressDelivery;
	}

	public void setAddressDelivery(String addressDelivery) {
		this.addressDelivery = addressDelivery;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	

	

}// end Order