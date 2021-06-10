package com.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.TipoDeObra;

@Repository
public interface TipoDeObraRepository extends JpaRepository<TipoDeObra, Integer>{
	Optional<TipoDeObra> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
