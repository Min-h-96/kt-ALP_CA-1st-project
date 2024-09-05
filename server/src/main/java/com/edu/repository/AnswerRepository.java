package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
