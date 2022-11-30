package com.iuh.nhom12.model;

/**
 * @author La Vo Minh Quan
 * @version 1.0
 * @created 21-Apr-2022 4:45:33 PM
 */
public class Category {

	private int id;

	private String categoryName;

	public Category() {

	}

	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}// end ProductType