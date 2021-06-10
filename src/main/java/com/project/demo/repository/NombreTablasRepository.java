package com.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.NombreTablas;

@Repository
public interface NombreTablasRepository extends JpaRepository<NombreTablas, Integer>{
	Optional<NombreTablas> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
