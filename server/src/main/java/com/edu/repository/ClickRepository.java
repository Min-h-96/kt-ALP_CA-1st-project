package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edu.dto.ClickCountInter;
import com.edu.entity.Click;

public interface ClickRepository extends JpaRepository<Click, Long> {	
	
	@Query("select c.question_id as question_id, count(*) as count\n"
			+ "	from Click as c\n"
			+ "	inner join Question as q on q.question_id = c.question_id\n"
			+ "	inner join Scenario as s on s.scenario_id = q.scenario_id\n"
			+ "	inner join Chatbot as cb on cb.chatbot_id = s.chatbot_id\n"
			+ "	inner join User as u on u.user_id = cb.user_id\n"
			+ "	where u.id = ?1 and\n"
			+ " c.year = ?2 and\n"
			+ " c.month = ?3\n"
			+ " group by c.question_id\n"
			+ " order by c.question_id asc")
	List<ClickCountInter> findCountByYearAndMonth(String user_id, int year, int month);
	
	
}
