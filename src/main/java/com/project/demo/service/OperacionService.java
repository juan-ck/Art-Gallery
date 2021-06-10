package com.project.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.entity.Operacion;
import com.project.demo.repository.OperacionRepository;
import com.project.demo.service.impl.OperacionServiceImpl;

@Service
@Transactional
public class OperacionService implements OperacionServiceImpl{

	@Autowired
	OperacionRepository repository;
	
	@Override
	public List<Operacion> list() {
		return repository.findAll();
	}

	@Override
	public Optional<Operacion> getOne(int id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Operacion> getByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	public void save(Operacion operacion) {
		repository.save(operacion);
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
