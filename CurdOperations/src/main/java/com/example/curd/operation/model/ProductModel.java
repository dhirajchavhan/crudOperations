package com.example.curd.operation.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductModel {
	
	@Id
	private int pid;
	
	private String pName;
	
	private String price;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	

}
