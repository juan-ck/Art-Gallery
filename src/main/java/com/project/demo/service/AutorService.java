package com.project.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.entity.Autor;
import com.project.demo.repository.AutorRepository;
import com.project.demo.service.impl.AutorServiceImpl;

@Service
@Transactional
public class AutorService implements AutorServiceImpl{

	@Autowired
	AutorRepository repository;
	
	@Override
	public List<Autor> list() {
		return repository.findAll();
	}

	@Override
	public Optional<Autor> getOne(int id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Autor> getByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	public void save(Autor autor) {
		repository.save(autor);
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
