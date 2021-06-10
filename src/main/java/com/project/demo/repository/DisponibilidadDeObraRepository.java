package com.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.DisponibilidadDeObra;

@Repository
public interface DisponibilidadDeObraRepository extends JpaRepository<DisponibilidadDeObra, Integer>{
	Optional<DisponibilidadDeObra> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
