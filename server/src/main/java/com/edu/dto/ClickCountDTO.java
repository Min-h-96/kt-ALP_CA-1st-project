package com.edu.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClickCountDTO {

	private Long question_id;
	private int count;
	
	@Builder
	public ClickCountDTO(Long question_id, int count) {
		super();
		this.question_id = question_id;
		this.count = count;
	}
	
}
