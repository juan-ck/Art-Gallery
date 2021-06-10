package com.project.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.entity.DisponibilidadDeUsuario;
import com.project.demo.repository.DisponiblidadDeUsuarioRepository;
import com.project.demo.service.impl.DisponibilidadDeUsuarioServiceImpl;

@Service
@Transactional
public class DisponibilidadDeUsuarioService implements DisponibilidadDeUsuarioServiceImpl{

	
	@Autowired
	DisponiblidadDeUsuarioRepository repository;
	
	@Override
	public List<DisponibilidadDeUsuario> list() {
		return repository.findAll();
	}

	@Override
	public Optional<DisponibilidadDeUsuario> getOne(int id) {
		return Optional.ofNullable(repository.findById(id).orElse(null));
	}

	@Override
	public Optional<DisponibilidadDeUsuario> getByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	public void save(DisponibilidadDeUsuario disponibilidadDeUsuario) {
		repository.save(disponibilidadDeUsuario);
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
