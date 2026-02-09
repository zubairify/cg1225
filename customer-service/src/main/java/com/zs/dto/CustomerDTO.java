package com.zs.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class CustomerDTO {
	@Min(value = 100, message = "Customer Id must be at least 3 digits")
	private int custId;
	@Pattern(regexp = "[A-Z][a-z ]{4,}", message = "Invalid customer name")
	private String custName;
	@Pattern(regexp = "[a-z0-9_-]+@[a-z0-9]+.[a-z]{2,}", message = "Invalid email format")
	private String email;
	@Pattern(regexp = "[6-9][0-9]{9}", message = "Invalid mobile number")
	private String mobile;
	
	// Getters and Setters
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
