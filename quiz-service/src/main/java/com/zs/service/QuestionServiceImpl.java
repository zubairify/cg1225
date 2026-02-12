package com.zs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.dto.OptionDTO;
import com.zs.dto.QuestionDTO;
import com.zs.entity.Option;
import com.zs.entity.Question;
import com.zs.error.InvalidQuestionException;
import com.zs.repo.QuestionRepository;

import lombok.extern.log4j.Log4j2;

@Service @Log4j2
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository repo;
	
	@Autowired
	private QuizService quizService;
	
	@Override
	public Question save(QuestionDTO dto) {
		log.info("Question service: saving question");
		Question quest = new Question();
		quest.setQuestId(dto.getQuestId());
		quest.setQuestion(dto.getQuestion());
		quest.setRightAns(dto.getRightAns());
		quest.setQuiz(quizService.find(dto.getQuizId()));
		
		List<Option> options = new ArrayList<Option>();
		for(OptionDTO opt : dto.getOptions()) {
			Option option = new Option();
			option.setOptId(opt.getOptId());
			option.setOption(opt.getOption());
			option.setQuest(quest);
			options.add(option);
		}
		quest.setOptions(options);
		return repo.save(quest);
	}

	@Override
	public Question find(int questId) {
		log.info("Question service: finding question by id: " + questId);
		return repo.findById(questId).orElseThrow(
			() -> new InvalidQuestionException("Question with id:"+questId+" not found"));
	}
}
