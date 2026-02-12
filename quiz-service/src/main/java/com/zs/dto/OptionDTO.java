package com.zs.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class OptionDTO {
	@Min(value = 1000, message = "Invalid option id")
	private int optId;
	@Pattern(regexp = "[A-Z][a-z ]{5,}")
	private String option;
}
