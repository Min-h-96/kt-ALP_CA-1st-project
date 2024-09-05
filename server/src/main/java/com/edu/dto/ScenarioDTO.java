package com.edu.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScenarioDTO {

	private Long scenario_id;
	private Long chatbot_id;
	private String title;
	private String content;
	private LocalDateTime createAt;
	private Boolean use;
	private Long used_count;
}
