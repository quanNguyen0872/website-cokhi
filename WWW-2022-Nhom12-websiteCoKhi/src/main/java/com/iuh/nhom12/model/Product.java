package com.iuh.nhom12.model;

/**
 * @author La Vo Minh Quan
 * @version 1.0
 * @created 21-Apr-2022 4:45:31 PM
 */
public class Product {
	private int id;

	private String name;

	private String productContent;

	private int inventoryNumber;

	private double price;

	private String manufacture;

	private String image;

	private Category category;

	private String categoryName;

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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
