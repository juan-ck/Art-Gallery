package com.project.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.entity.DisponibilidadDeObra;
import com.project.demo.repository.DisponibilidadDeObraRepository;
import com.project.demo.service.impl.DisponibilidadDeObraServiceImpl;

@Service
@Transactional
public class DisponibilidadDeObraService implements DisponibilidadDeObraServiceImpl{

	@Autowired
	DisponibilidadDeObraRepository repository;
	
	@Override
	public List<DisponibilidadDeObra> list() {
		return repository.findAll();
	}

	@Override
	public Optional<DisponibilidadDeObra> getOne(int id) {
		return repository.findById(id);
	}

	@Override
	public Optional<DisponibilidadDeObra> getByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	public void save(DisponibilidadDeObra disponibilidadDeObra) {
		repository.save(disponibilidadDeObra);
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
