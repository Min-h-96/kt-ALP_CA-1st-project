package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edu.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
	
	@Query("select new Answer(a.answer_id, a.question_id, a.content, a.use)\n"
			+ " from Question as q\n"
			+ " full outer join Answer as a on a.question_id = q.question_id\n"
			+ " where q.scenario_id = ?1 and a.use = true and a.answer_id is not null")
	List<Answer> findByScenarioId(Long scenario_id);

}
