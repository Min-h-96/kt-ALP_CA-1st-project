package com.edu.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDTO {

	private Long question_id;
	private Long scenario_id;
	private Integer question_step;
	private String content;
	private Long pre_question_id;
	private Boolean use;
	
	@Builder
	public QuestionDTO(Long question_id, Long scenario_id, Integer question_step, String content, Long pre_question_id,
			Boolean use) {
		super();
		this.question_id = question_id;
		this.scenario_id = scenario_id;
		this.question_step = question_step;
		this.content = content;
		this.pre_question_id = pre_question_id;
		this.use = use;
	}
	
}
