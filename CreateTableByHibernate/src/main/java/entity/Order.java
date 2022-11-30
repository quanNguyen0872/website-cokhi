package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author La Vo Minh Quan
 * @version 1.0
 * @created 21-Apr-2022 4:45:31 PM
 */
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, name = "order_date")
	private Date orderDate;

	@Column(nullable = true, name = "address_delivery")
	private String addressDelivery;
	
	@Column(nullable = true)
	private int status;

	@ManyToOne
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customer;

//	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();

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

//	public double getTotal() {
//		return 0;
//	}

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

//	public Set<OrderDetail> getOrderDetails() {
//		return orderDetails;
//	}
//
//	public void setOrderDetails(Set<OrderDetail> orderDetails) {
//		this.orderDetails = orderDetails;
//	}

}// end Order