package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.SessionStatus;

public interface SessionStatusRepository extends JpaRepository<SessionStatus, Integer>{

}
