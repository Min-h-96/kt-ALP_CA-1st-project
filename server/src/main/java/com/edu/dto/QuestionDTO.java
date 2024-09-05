package com.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

	private Long question_id;
	private Long scenario_id;
	private Integer question_step;
	private String content;
	private Long pre_question_id;
	private Boolean use;
}
