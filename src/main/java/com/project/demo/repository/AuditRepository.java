package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Audit;

public interface AuditRepository extends JpaRepository<Audit, Integer>{

}
