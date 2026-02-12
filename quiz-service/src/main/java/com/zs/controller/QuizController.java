package com.zs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.dto.QuizDTO;
import com.zs.entity.Quiz;
import com.zs.service.QuizService;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController 
@RequestMapping("/api/v1/quizes")
public class QuizController {

	@Autowired
	private QuizService service;
	
	@PostMapping("/save")
	public ResponseEntity<Quiz> save(@RequestBody @Valid QuizDTO dto) {
		log.info("Request received to save quiz");
		Quiz quiz = service.save(dto);
		return new ResponseEntity<Quiz>(quiz, HttpStatus.CREATED);
	}
	
	@GetMapping("/{quizId}")
	public ResponseEntity<Quiz> find(@PathVariable int quizId) {
		log.info("Request received to find quiz by id");
		Quiz quiz = service.find(quizId);
		return new ResponseEntity<Quiz>(quiz, HttpStatus.CREATED);
	}
}
