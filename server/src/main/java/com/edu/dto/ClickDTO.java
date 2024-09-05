package com.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClickDTO {

	private Long click_id;
	private Long question_id;
	private Integer year;
	private Integer month;
	private Integer day;
	private Integer hour;
}
