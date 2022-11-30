package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author La Vo Minh Quan
 * @version 1.0
 * @created 21-Apr-2022 4:45:31 PM
 */
@Entity
@Table(name = "order_details")
@IdClass(OrderDetail_PK.class)
public class OrderDetail {
	@Id
	@ManyToOne
	@JoinColumn(name = "order_id", columnDefinition = "INT")
	private Order order;

	@Id
	@ManyToOne
	@JoinColumn(name = "product_id", columnDefinition = "INT")
	private Product product;

	@Column(nullable = false)
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
