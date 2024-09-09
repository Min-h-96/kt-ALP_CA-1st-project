package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edu.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	@Query("select new Question(question_id, scenario_id, question_step, content, pre_question_id, use)\n"
			+ " from Question\n"
			+ " where scenario_id = ?1\n"
			+ " order by question_step asc")
	List<Question> findByScenarioIdOrderByQuestionStepAsc(Long scenario_id);

}
