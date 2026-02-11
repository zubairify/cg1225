package com.zs.cotroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zs.error.InvalidOrderException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = InvalidOrderException.class)
	public ResponseEntity<String> handleInvalidOrder(InvalidOrderException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleInputValidation(MethodArgumentNotValidException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
