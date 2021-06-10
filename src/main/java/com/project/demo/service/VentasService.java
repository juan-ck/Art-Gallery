package com.project.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.entity.Ventas;
import com.project.demo.repository.VentasRepository;
import com.project.demo.service.impl.VentasServiceImpl;

@Service
@Transactional
public class VentasService implements VentasServiceImpl{

	@Autowired
	VentasRepository repository;
	
	@Override
	public List<Ventas> list() {
		return repository.findAll();
	}

	@Override
	public Optional<Ventas> getOne(int id) {
		return repository.findById(id);
	}

	@Override
	public void save(Ventas venta) {
		repository.save(venta);
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}

	@Override
	public boolean existsById(int id) {
		return repository.existsById(id);
	}

}
