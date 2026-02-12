package com.zs.error;

public class InvalidQuestionException extends RuntimeException {

	public InvalidQuestionException() {
	}

	public InvalidQuestionException(String message) {
		super(message);
	}
}
