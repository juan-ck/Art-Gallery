package com.project.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.entity.Obra;
import com.project.demo.repository.ObraRepository;
import com.project.demo.service.impl.ObraServiceImpl;

@Service
@Transactional
public class ObraService implements ObraServiceImpl{

	@Autowired
	ObraRepository repository;
	
	//public List<Obra> listaVisible
	
	@Override
	public List<Obra> list() {
		return repository.findAll();
	}

	@Override
	public Optional<Obra> getOne(int id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Obra> getByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	public void save(Obra obra) {
		repository.save(obra);
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}

	@Override
	public boolean existsById(int id) {
		return repository.existsById(null);
	}

	@Override
	public boolean existsByNombre(String nombre) {
		return repository.existsByNombre(nombre);
	}

}
