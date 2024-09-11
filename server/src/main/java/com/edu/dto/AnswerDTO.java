package com.edu.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerDTO {

	private Long answer_id;
	private Long question_id;
	private String content;
	private Boolean use;
	
	@Builder
	public AnswerDTO(Long answer_id, Long question_id, String content, Boolean use) {
		super();
		this.answer_id = answer_id;
		this.question_id = question_id;
		this.content = content;
		this.use = use;
	}
	
}
