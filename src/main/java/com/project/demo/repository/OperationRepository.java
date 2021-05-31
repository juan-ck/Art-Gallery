package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Integer>{

}
