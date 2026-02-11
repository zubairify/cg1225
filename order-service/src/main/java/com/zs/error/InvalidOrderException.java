package com.zs.error;

public class InvalidOrderException extends RuntimeException {

	public InvalidOrderException() {
	}

	public InvalidOrderException(String message) {
		super(message);
	}
}
