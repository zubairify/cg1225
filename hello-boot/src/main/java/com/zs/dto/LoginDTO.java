package com.zs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginDTO {
	@NotBlank(message = "User Id cannot be blank")
	@Size(min = 4, message = "User Id must be at least 4 chars")
	private String userid;
	@Pattern(regexp = "[a-z0-9]{4,}", message = "Password must be at least 4 chars")
	private String password;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
