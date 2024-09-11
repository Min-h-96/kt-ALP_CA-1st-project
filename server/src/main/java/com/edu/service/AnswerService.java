package com.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dto.AnswerDTO;
import com.edu.entity.Answer;
import com.edu.repository.AnswerRepository;

import jakarta.transaction.Transactional;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepository;
	
	public List<AnswerDTO> loadAnswers(Long scenario_id) {
		List<Answer> answers = answerRepository.findByScenarioId(scenario_id);
		
		List<AnswerDTO> result = new ArrayList<AnswerDTO>();
		
		for (Answer a : answers) {
			result.add(AnswerDTO.builder()
								.answer_id(a.getAnswer_id())
								.question_id(a.getQuestion_id())
								.content(a.getContent())
								.use(a.getUse())
								.build());
		}
		
		return result;
	}
	
	@Transactional
	public void updateAnswer(AnswerDTO answerDTO) {
		Answer answer = answerRepository.findById(answerDTO.getAnswer_id()).orElse(null);
		
		answer.setContent(answerDTO.getContent());
	}
}
