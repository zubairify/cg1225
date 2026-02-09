package com.zs.error;

public class InvalidCustomerException extends RuntimeException {
	public InvalidCustomerException() {
	}

	public InvalidCustomerException(String message) {
		super(message);
	}
}
