package com.edu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dto.UserDTO;

import jakarta.servlet.http.HttpSession;

@RestController
public class SessionController {

	@GetMapping("/api/session/user")
    public ResponseEntity<UserDTO> getUserFromSession(HttpSession session) {
        // 세션에서 User 객체 가져오기
		UserDTO user = (UserDTO) session.getAttribute("user");
		
		System.out.println(user);
        
        if (user != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
