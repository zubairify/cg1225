package com.zs.error;

public class InvalidProductException extends RuntimeException {

	public InvalidProductException() {
	}

	public InvalidProductException(String message) {
		super(message);
	}
}
