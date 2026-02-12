package com.zs.service;

import com.zs.dto.QuestionDTO;
import com.zs.entity.Question;

public interface QuestionService {

	Question save(QuestionDTO dto);
	
	Question find(int questId);
	
}
