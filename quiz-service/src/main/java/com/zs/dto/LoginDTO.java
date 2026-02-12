package com.zs.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoginDTO {
	@Pattern(regexp = "[a-z][a-z0-9]{4,}", message = "Invalid userid")
	private String userid;
	@Pattern(regexp = "[a-z0-9-_]{6,}", message = "Invalid password")
	private String passwd;
}
