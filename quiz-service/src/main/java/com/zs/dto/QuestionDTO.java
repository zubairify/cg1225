package com.zs.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class QuestionDTO {

	@Min(value = 100, message = "Invalid quiz id")
	private int quizId;
	@Min(value = 1000, message = "Invalid question id")
	private int questId;
	@Pattern(regexp = "[A-Z][a-z ]{5,}")
	private String question;
	@Min(value = 1000, message = "Invalid option id")
	private int rightAns;
	
	@NotEmpty
	private OptionDTO[] options = new OptionDTO[4];
}
