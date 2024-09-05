package com.edu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chatbot")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chatbot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chatbot_id;
	
	private Long user_id; 
}
