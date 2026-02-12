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

import com.zs.dto.QuestionDTO;
import com.zs.entity.Question;
import com.zs.service.QuestionService;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	@PostMapping("/save")
	public ResponseEntity<Question> save(@RequestBody @Valid QuestionDTO dto) {
		log.info("Request received to save question");
		Question quest = service.save(dto);
		return new ResponseEntity<Question>(quest, HttpStatus.CREATED);
	}
	
	@GetMapping("/{questId}")
	public ResponseEntity<Question> find(@PathVariable int questId) {
		log.info("Request received to find question");
		Question quest = service.find(questId);
		return new ResponseEntity<Question>(quest, HttpStatus.CREATED);
	}
}
