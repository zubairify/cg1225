package com.zs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zs.error.FlightNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = FlightNotFoundException.class)
	public ResponseEntity<String> handleFlightNotFound(FlightNotFoundException e) {
		ResponseEntity<String> resp = new ResponseEntity<String>(
										e.getMessage(), HttpStatus.NOT_FOUND);
		return resp;
	}
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException e) {
		String exMsg = e.getMessage();
		int idx = exMsg.lastIndexOf("[");
		
		ResponseEntity<String> resp = new ResponseEntity<String>(
				exMsg.substring(idx+1, exMsg.length()-3), HttpStatus.BAD_REQUEST);
		return resp;
	}
}

