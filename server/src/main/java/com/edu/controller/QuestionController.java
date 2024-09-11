package com.edu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dto.QuestionDTO;
import com.edu.service.QuestionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/question/{scenario_id}")
	public ResponseEntity<List<QuestionDTO>> getQuestions(@PathVariable("scenario_id") Long scenario_id) {
		List<QuestionDTO> questions = (ArrayList<QuestionDTO>) questionService.loadQuestions(scenario_id);
		
		return ResponseEntity.status(200).body(questions);
	}
	
	@PostMapping("/question")
	public ResponseEntity<QuestionDTO> update(@RequestBody QuestionDTO body) {
		questionService.updateQuestion((QuestionDTO) body);
		
		
		return ResponseEntity.ok().build();
	}
	
}
