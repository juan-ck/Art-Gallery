package com.project.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.entity.EstadoSesion;
import com.project.demo.repository.EstadoSesionRepository;
import com.project.demo.service.impl.EstadoSesionServiceImpl;

@Service
@Transactional
public class EstadoSesionService implements EstadoSesionServiceImpl{

	@Autowired
	EstadoSesionRepository repository;
	
	@Override
	public List<EstadoSesion> list() {
		return repository.findAll();
	}

	@Override
	public Optional<EstadoSesion> getOne(int id) {
		return Optional.ofNullable(repository.findById(id).orElse(null));
	}

	@Override
	public Optional<EstadoSesion> getByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	public void save(EstadoSesion estadoSesion) {
		repository.save(estadoSesion);
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}

	@Override
	public boolean existsById(int id) {
		return repository.existsById(id);
	}

	@Override
	public boolean existsByNombre(String nombre) {
		return repository.existsByNombre(nombre);
	}

}
