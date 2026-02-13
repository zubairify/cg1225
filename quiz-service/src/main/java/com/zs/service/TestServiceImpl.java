package com.zs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.dto.AttemptDTO;
import com.zs.dto.TestDTO;
import com.zs.entity.Question;
import com.zs.entity.Quiz;
import com.zs.entity.Result;
import com.zs.entity.User;
import com.zs.repo.ResultRespository;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private ResultRespository repo;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private QuestionService questService;
	
	@Override
	public Result submit(TestDTO dto) {
		Result result = new Result();
		User usr = userService.find(dto.getUserid());
		Quiz quiz = quizService.find(dto.getQuizId());
		double score = 0.0;
		List<AttemptDTO> attempted = dto.getAttempts();
		for(AttemptDTO atmpt : attempted) {
			Question quest = questService.find(atmpt.getQuestId());
			if(quest.getRightAns() == atmpt.getAnsId()) {
				System.out.println("-- Score added");
				score += 10;
			}
		}
		
		result.setScore(score);
		if(score >= 60)
			result.setResult("Pass");
		
		result.setUser(usr);
		result.setQuiz(quiz);
		
		return repo.save(result);
	}
}
