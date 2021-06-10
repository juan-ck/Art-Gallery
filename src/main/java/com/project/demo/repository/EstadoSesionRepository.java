package com.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.EstadoSesion;

@Repository
public interface EstadoSesionRepository extends JpaRepository<EstadoSesion, Integer>{
	Optional<EstadoSesion> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
