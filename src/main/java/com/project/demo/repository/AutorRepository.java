package com.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{
	Optional<Autor> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
