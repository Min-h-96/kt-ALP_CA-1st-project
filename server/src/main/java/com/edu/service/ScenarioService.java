package com.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dto.ScenarioDTO;
import com.edu.entity.Scenario;
import com.edu.repository.ScenarioRepository;

@Service
public class ScenarioService {
	
	@Autowired
	private ScenarioRepository scenarioRepository;
	
	public List<ScenarioDTO> loadScenarios(Long user_id) {
		List<Scenario> scenarios = scenarioRepository.findAllbyUserId(user_id);
		
		List<ScenarioDTO> result = new ArrayList<ScenarioDTO>();
		
		for (Scenario s : scenarios) {
			result.add(ScenarioDTO.builder()
								  .chatbot_id(s.getChatbot_id())
								  .scenario_id(s.getScenario_id())
								  .title(s.getTitle())
								  .content(s.getContent())
								  .createdAt(s.getCreatedAt())
								  .build());
		}
		
		return result;
	}
}
