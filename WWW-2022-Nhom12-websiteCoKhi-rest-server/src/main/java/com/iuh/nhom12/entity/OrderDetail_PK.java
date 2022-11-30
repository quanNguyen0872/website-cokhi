package com.iuh.nhom12.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class OrderDetail_PK implements Serializable {

	private static final long serialVersionUID = 1L;

	private int order;
	private int product;

	public OrderDetail_PK() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetail_PK other = (OrderDetail_PK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}

}
