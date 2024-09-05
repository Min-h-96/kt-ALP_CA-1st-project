package com.edu.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dto.UserDTO;
import com.edu.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api")
@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO body, HttpServletRequest httpServletRequest) {
		
		Optional<UserDTO> user = userService.login(body.getId(), body.getPassword());
		
		if (user.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		
		HttpSession session = httpServletRequest.getSession(true);
		session.setAttribute("id", body.getId());
		session.setMaxInactiveInterval(600);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/logout")
	public ResponseEntity<UserDTO> logout(HttpServletRequest httpServletRequest) {
		
		HttpSession session = httpServletRequest.getSession(false);
		
        if(session != null) {
            session.invalidate();
        }
		
		return ResponseEntity.ok().build();
	}
}
