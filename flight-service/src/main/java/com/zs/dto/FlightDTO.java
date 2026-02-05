package com.zs.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class FlightDTO {
	@Min(value = 100, message = "Code must be min 3 digits") 
	@Max(value = 9999, message = "Code must be max 4 digits")
	private int code;
	@Pattern(regexp = "[A-Z][A-Za-z ]{2,}", message = "Carrier must be min 3 char starting with capital")
	private String carrier;
	@Pattern(regexp = "[A-Z][a-z]{2,}", message = "Source must be min 3 char starting with capital")
	private String source;
	@Pattern(regexp = "[A-Z][a-z]{2,}", message = "Destination must be min 3 char starting with capital")
	private String destination;

	// Getters and Setters
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
}
