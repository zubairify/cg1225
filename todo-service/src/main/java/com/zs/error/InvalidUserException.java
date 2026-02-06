package com.zs.error;

public class InvalidUserException extends RuntimeException {

	public InvalidUserException() {
	}

	public InvalidUserException(String message) {
		super(message);
	}
}
