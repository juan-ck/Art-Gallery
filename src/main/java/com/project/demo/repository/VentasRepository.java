package com.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.Ventas;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer>{
	Optional<Ventas> findById(int id);
    boolean existsById(int id);
}
