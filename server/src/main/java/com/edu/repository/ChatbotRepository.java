package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.entity.Chatbot;

public interface ChatbotRepository extends JpaRepository<Chatbot, Long>{

}
