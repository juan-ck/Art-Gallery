package com.project.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.entity.CategoriaDeObra;
import com.project.demo.repository.CategoriaDeObraRepository;
import com.project.demo.service.impl.CategoriaDeObraServiceImpl;

@Service
@Transactional
public class CategoriaDeObraService implements CategoriaDeObraServiceImpl{

	@Autowired
	CategoriaDeObraRepository repository;
	
	@Override
	public List<CategoriaDeObra> list() {
		return repository.findAll();
	}

	@Override
	public Optional<CategoriaDeObra> getOne(int id) {
		return repository.findById(id);
	}

	@Override
	public Optional<CategoriaDeObra> getByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	public void save(CategoriaDeObra categoriaDeObra) {
		repository.save(categoriaDeObra);
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
