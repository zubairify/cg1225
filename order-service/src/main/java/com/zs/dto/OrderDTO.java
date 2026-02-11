package com.zs.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderDTO {
	@Min(value = 100, message = "Invalid Customer Id")
	private int custId;
	@NotNull(message = "Order cannot be placed without products")
	private int[] codes;

	// Getters and Setters
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int[] getCodes() {
		return codes;
	}
	public void setCodes(int[] codes) {
		this.codes = codes;
	}
}
