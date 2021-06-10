package com.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.DisponibilidadDeUsuario;

@Repository
public interface DisponiblidadDeUsuarioRepository extends JpaRepository<DisponibilidadDeUsuario, Integer>{
	Optional<DisponibilidadDeUsuario> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
