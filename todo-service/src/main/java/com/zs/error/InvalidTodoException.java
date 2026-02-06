package com.zs.error;

public class InvalidTodoException extends RuntimeException {

	public InvalidTodoException() {
	}

	public InvalidTodoException(String message) {
		super(message);
	}
}
