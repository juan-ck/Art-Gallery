package com.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.Operacion;

@Repository
public interface OperacionRepository extends JpaRepository<Operacion, Integer>{
	Optional<Operacion> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
