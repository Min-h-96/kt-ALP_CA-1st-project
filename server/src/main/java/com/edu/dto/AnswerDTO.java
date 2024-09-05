package com.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {

	private Long answer_id;
	private Long question_id;
	private String content;
	private Boolean use;
}
