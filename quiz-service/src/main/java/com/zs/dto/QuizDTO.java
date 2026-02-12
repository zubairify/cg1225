package com.zs.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class QuizDTO {
	@Min(value = 100, message = "Invalid quiz id")
	private int quizId;
	@Pattern(regexp = "[A-Z][a-z ]{5,}")
	private String title;
	
}
