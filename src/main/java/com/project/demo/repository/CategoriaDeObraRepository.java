package com.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.CategoriaDeObra;

@Repository
public interface CategoriaDeObraRepository extends JpaRepository<CategoriaDeObra, Integer>{
	Optional<CategoriaDeObra> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
