package com.edu.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClickDTO {

	private Long click_id;
	private Long question_id;
	private Integer year;
	private Integer month;
	private Integer day;
	private Integer hour;
	
	@Builder
	public ClickDTO(Long click_id, Long question_id, Integer year, Integer month, Integer day, Integer hour) {
		super();
		this.click_id = click_id;
		this.question_id = question_id;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
	}
}
