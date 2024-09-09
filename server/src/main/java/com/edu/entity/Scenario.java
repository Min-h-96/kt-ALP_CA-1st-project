package com.edu.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "scenario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scenario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scenario_id;
	
	private Long chatbot_id;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private Boolean use;
	private Long used_count;
}
