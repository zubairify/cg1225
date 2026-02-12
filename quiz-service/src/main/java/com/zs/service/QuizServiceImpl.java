package com.zs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.dto.QuizDTO;
import com.zs.entity.Quiz;
import com.zs.error.InvalidQuizException;
import com.zs.repo.QuizRepository;

import lombok.extern.log4j.Log4j2;

@Service @Log4j2
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository repo;
	
	@Override
	public Quiz save(QuizDTO dto) {
		log.info("Quiz service requested to save quiz");
		return repo.save(QuizService.transform(dto));
	}

	@Override
	public Quiz find(int quizId) {
		log.info("Quiz service finding quiz by id");
		return repo.findById(quizId).orElseThrow(
			() -> new InvalidQuizException("Quiz not found with id:" + quizId));
	}
}
