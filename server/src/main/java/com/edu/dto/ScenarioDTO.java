package com.edu.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScenarioDTO {

	private Long scenario_id;
	private Long chatbot_id;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private Boolean use;
	private Long used_count;
	
	@Builder
	public ScenarioDTO(Long scenario_id, Long chatbot_id, String title, String content, LocalDateTime createdAt,
			Boolean use, Long used_count) {
		super();
		this.scenario_id = scenario_id;
		this.chatbot_id = chatbot_id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.use = use;
		this.used_count = used_count;
	}
	
}
