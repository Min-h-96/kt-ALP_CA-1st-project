package com.edu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dto.UserDTO;
import com.edu.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Optional<UserDTO> login(String id, String password) {
		Optional<UserDTO> user = userRepository.findById(id)
				.map(u -> UserDTO.builder()
								 .user_id(u.getUser_id())
								 .id(u.getId())
								 .password(u.getPassword())
								 .email(u.getEmail())
								 .phone(u.getPhone())
								 .build());
		
		// 일치하는 아이디가 없는 경우
		if (user.isEmpty()) {
			return Optional.empty();
		}
		
		// 비밀번호가 틀린 경우
		if (!user.get().getPassword().equals(password)) {
			return Optional.empty();
		}
		
		return user;
	}
	
}
