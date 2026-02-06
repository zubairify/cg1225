package com.zs.dto;

import jakarta.validation.constraints.Pattern;

public class TodoDTO {
	@Pattern(regexp = "[A-Z][a-z ]{5,}", message = "Enter valid task details")
	private String task;

	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
}
