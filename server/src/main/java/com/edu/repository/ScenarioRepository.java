package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edu.entity.Scenario;

public interface ScenarioRepository extends JpaRepository<Scenario, Long>{

	@Query("select new Scenario(s.scenario_id, s.chatbot_id, s.title, s.content, s.createdAt, s.use, s.used_count)\n"
			+ "	from Scenario as s\n"
			+ "	inner join Chatbot as c on s.chatbot_id = c.chatbot_id\n"
			+ "	inner join User as u on c.user_id = u.user_id\n"
			+ "	where u.user_id = ?1")
	List<Scenario> findAllbyUserId(Long user_id);
}
