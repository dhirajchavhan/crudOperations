package com.example.curd.operation.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoryModel {
	
	@Id
	private int id;
	
	private String category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
