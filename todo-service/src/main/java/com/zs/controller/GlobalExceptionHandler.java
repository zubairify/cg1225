package com.zs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zs.error.InvalidTodoException;
import com.zs.error.InvalidUserException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = InvalidUserException.class)
	public ResponseEntity<String> handleInvalidUser(InvalidUserException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = InvalidTodoException.class)
	public ResponseEntity<String> handleInvalidTodo(InvalidTodoException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationError(MethodArgumentNotValidException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
