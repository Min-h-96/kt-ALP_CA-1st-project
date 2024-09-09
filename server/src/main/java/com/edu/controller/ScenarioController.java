package com.edu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dto.ScenarioDTO;
import com.edu.dto.UserDTO;
import com.edu.service.ScenarioService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ScenarioController {

	
	@Autowired
	private ScenarioService scenarioService;
	
	@GetMapping("/scenarios")
	public ResponseEntity<List<ScenarioDTO>> getScenarios(HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		
		List<ScenarioDTO> scenarios = (ArrayList<ScenarioDTO>) scenarioService.loadScenarios(user.getUser_id());
		
		return ResponseEntity.status(200).body(scenarios);
	}
}
