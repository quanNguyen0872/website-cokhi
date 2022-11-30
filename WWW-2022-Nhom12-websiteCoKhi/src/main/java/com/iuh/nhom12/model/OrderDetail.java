package com.iuh.nhom12.model;

/**
 * @author La Vo Minh Quan
 * @version 1.0
 * @created 21-Apr-2022 4:45:31 PM
 */
public class OrderDetail {

	private Order order;

	private Product product;

	private int quantity;

	public OrderDetail() {
	}

	public OrderDetail(Order order, Product product, int quantity) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return product.getPrice() * quantity;
	}

}
