package com.edu.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dto.ClickCountDTO;
import com.edu.dto.ClickCountInter;
import com.edu.repository.ClickRepository;

@Service
public class ClickService {

	@Autowired
	private ClickRepository clickRepository;
	
	public List<ClickCountDTO> findByYearAndMonth(String user_id, int year, int month) {
		List<ClickCountInter> lst = clickRepository.findCountByYearAndMonth(user_id, year, month);

		List<ClickCountDTO> result = new ArrayList<ClickCountDTO>();
		
		for (ClickCountInter c : lst) {
			result.add(ClickCountDTO.builder()
									.question_id(c.getQuestion_id())
									.count(c.getCount())
									.build());
		}
		
		return result;
	}
}
