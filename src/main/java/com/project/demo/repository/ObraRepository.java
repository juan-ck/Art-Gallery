package com.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.Obra;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Integer>{
	Optional<Obra> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
