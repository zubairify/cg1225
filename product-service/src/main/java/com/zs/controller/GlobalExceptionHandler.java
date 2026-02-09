package com.zs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zs.error.InvalidProductException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = InvalidProductException.class)
	public ResponseEntity<String> handleInvalidProduct(InvalidProductException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleInputValidation(MethodArgumentNotValidException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
