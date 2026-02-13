package com.zs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zs.error.InvalidLoginException;
import com.zs.error.InvalidQuestionException;
import com.zs.error.InvalidQuizException;
import com.zs.error.InvalidUserException;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice @Log4j2
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = InvalidLoginException.class)
	public ResponseEntity<String> handleInvalidLogin(InvalidLoginException e) {
		log.error("Invalid login attempt");
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = InvalidUserException.class)
	public ResponseEntity<String> handleInvalidUser(InvalidUserException e) {
		log.error("Invalid login attempt");
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = InvalidQuizException.class)
	public ResponseEntity<String> handleInvalidQuiz(InvalidQuizException e) {
		log.error("Invalid quiz id requested");
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = InvalidQuestionException.class)
	public ResponseEntity<String> handleInvalidQuest(InvalidQuestionException e) {
		log.error("Invalid question id requested");
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationError(MethodArgumentNotValidException e) {
		log.error("Request with invalid input");
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/*
	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<String> ellipsisHandler(Exception e) {
		log.error("Ellipsis exception handler");
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	} */
}
