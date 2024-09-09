package com.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dto.QuestionDTO;
import com.edu.entity.Question;
import com.edu.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	public List<QuestionDTO> loadQuestions(Long scenario_id) {
		List<Question> questions = questionRepository.findByScenarioIdOrderByQuestionStepAsc(scenario_id);
		
		List<QuestionDTO> result = new ArrayList<QuestionDTO>();
		
		for (Question q : questions) {
			result.add(QuestionDTO.builder()
								  .question_id(q.getQuestion_id())
								  .scenario_id(q.getScenario_id())
								  .question_step(q.getQuestion_step())
								  .content(q.getContent())
								  .pre_question_id(q.getPre_question_id())
								  .use(q.getUse())
								  .build());
		}
		
		return result;
	}
}
