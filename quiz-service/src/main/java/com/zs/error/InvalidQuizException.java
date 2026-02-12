package com.zs.error;

public class InvalidQuizException extends RuntimeException {

	public InvalidQuizException() {
	}

	public InvalidQuizException(String message) {
		super(message);
	}
}
