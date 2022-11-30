package com.iuh.nhom12.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author La Vo Minh Quan
 * @version 1.0
 * @created 21-Apr-2022 4:45:33 PM
 */
@Entity
@Table(name = "categories")
public class Category {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "category_name")
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