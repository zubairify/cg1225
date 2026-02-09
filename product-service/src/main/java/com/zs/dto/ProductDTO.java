package com.zs.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class ProductDTO {
	@Min(value = 1000, message = "Product code must be at least 4 digits")
	private int code;
	@Pattern(regexp = "[A-Z][A-Za-z0-9 ]{4,}", message = "Invalid product name")
	private String prodName;
	@Min(value = 99, message = "Price must be minimum 99")
	@Max(value = 99999, message = "Price cannot exceed 99999")
	private double price;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
