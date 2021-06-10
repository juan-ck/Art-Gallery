package com.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.Auditoria;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Integer>{
	Optional<Auditoria> findById(int id);
    boolean existsById(int id);
}
