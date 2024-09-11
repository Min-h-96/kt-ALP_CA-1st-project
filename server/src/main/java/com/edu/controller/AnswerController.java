package com.edu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dto.AnswerDTO;
import com.edu.service.AnswerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	
	@GetMapping("/answer/{scenario_id}")
	public ResponseEntity<List<AnswerDTO>> getAnswers(@PathVariable("scenario_id") Long scenario_id) {
		List<AnswerDTO> answers = (ArrayList<AnswerDTO>) answerService.loadAnswers(scenario_id);
		
		return ResponseEntity.status(200).body(answers);
	}
	
	@PostMapping("/answer")
	public ResponseEntity<AnswerDTO> update(@RequestBody AnswerDTO body) {
		answerService.updateAnswer((AnswerDTO) body);
		
		
		return ResponseEntity.ok().build();
	}
	
}
