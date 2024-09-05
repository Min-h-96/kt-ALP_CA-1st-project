package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.entity.Click;

public interface ClickRepository extends JpaRepository<Click, Long> {

}
