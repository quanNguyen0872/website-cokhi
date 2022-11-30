package com.iuh.nhom12.entity;

import javax.persistence.CascadeType;
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
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "product_name", nullable = false, columnDefinition = "NVARCHAR(100)")
	private String name;

	@Column(name = "product_content", nullable = true, columnDefinition = "NVARCHAR(200)")
	private String productContent;

	@Column(name = "inventory_number", nullable = false)
	private int inventoryNumber;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false, columnDefinition = "NVARCHAR(100)")
	private String manufacture;

	@Column(name = "image", columnDefinition = "VARCHAR(300)", nullable = true)
	private String image;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "categoryId", nullable = false)
	private Category category;

	public Product() {
	}

	public Product(String name, String productContent, int inventoryNumber, double price, String manufacture,
			String image, Category category) {
		super();
		this.name = name;
		this.productContent = productContent;
		this.inventoryNumber = inventoryNumber;
		this.price = price;
		this.manufacture = manufacture;
		this.image = image;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public int getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(int inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
