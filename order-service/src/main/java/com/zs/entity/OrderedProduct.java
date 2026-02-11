package com.zs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "ordered_products")
public class OrderedProduct {
	@Id
	private int code;
	
	@JsonBackReference
	@ManyToOne @JoinColumn(name = "ord_no")
	private Order order;

	// Getters and Setters
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
