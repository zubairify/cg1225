package com.zs.error;

public class FlightNotFoundException extends RuntimeException {

	public FlightNotFoundException() {
	}

	public FlightNotFoundException(String message) {
		super(message);
	}
}
