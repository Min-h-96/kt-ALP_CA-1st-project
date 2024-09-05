package com.edu.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	
	private Long user_id;
	private String id;
	private String password;
	private String email;
	private String phone;
	
	@Builder
	public UserDTO(Long user_id, String id, String password, String email, String phone) {
		super();
		this.user_id = user_id;
		this.id = id;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
}
