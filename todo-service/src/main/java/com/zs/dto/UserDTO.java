package com.zs.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class UserDTO {
	@Min(value = 100, message = "User ID must be at least 3 digits")
	private int uid;
	@Pattern(regexp = "[A-Z][a-z ]{4,}", message = "Enter valid name")
	private String name;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
