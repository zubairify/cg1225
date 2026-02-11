package com.zs.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class StatusDTO {
	@Min(value = 1, message = "Order no cannot be zero")
	private int ordNo;
	@Pattern(regexp = "Pending|Delivered")
	private String status;
	
	// Getters and Setters
	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
