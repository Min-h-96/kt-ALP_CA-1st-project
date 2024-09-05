package com.edu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "click")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Click {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long click_id;
	
	private Long question_id;
	private Integer year;
	private Integer month;
	private Integer day;
	private Integer hour;
}
