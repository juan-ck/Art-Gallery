package com.project.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.entity.NombreTablas;
import com.project.demo.repository.NombreTablasRepository;
import com.project.demo.service.impl.NombreTablasServiceImpl;

@Service
@Transactional
public class NombreTablasService implements NombreTablasServiceImpl{

	@Autowired
	NombreTablasRepository repository;
	
	@Override
	public List<NombreTablas> list() {
		return repository.findAll();
	}

	@Override
	public Optional<NombreTablas> getOne(int id) {
		return repository.findById(id);
	}

	@Override
	public Optional<NombreTablas> getByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	public void save(NombreTablas nombreTablas) {
		repository.save(nombreTablas);
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
