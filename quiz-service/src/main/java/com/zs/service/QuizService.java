package com.zs.service;

import com.zs.dto.QuizDTO;
import com.zs.entity.Quiz;

public interface QuizService {

	Quiz save(QuizDTO dto);
	
	Quiz find(int quizId);
	
	static Quiz transform(QuizDTO dto) {
		Quiz quiz = new Quiz();
		quiz.setQuizId(dto.getQuizId());
		quiz.setTitle(dto.getTitle());
		return quiz;
	}
}
