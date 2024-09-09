package com.edu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dto.ClickCountDTO;
import com.edu.dto.UserDTO;
import com.edu.service.ClickService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/click")
@Slf4j
public class ClickController {

	@Autowired
	private ClickService clickService;
	
	@GetMapping()
	public ResponseEntity<List<ClickCountDTO>> getClicks(HttpSession session, @RequestParam(value = "year") int year, @RequestParam(value = "month") int month) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		
		List<ClickCountDTO> clicks = (ArrayList<ClickCountDTO>) clickService.findByYearAndMonth(user.getId(), year, month);
		
		return ResponseEntity.status(200).body(clicks);
	}
}
