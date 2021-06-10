package com.project.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.demo.entity.DisponibilidadDeUsuario;

public interface DisponibilidadDeUsuarioServiceImpl {

	public List<DisponibilidadDeUsuario> list();
	public Optional<DisponibilidadDeUsuario> getOne(int id);
	public Optional<DisponibilidadDeUsuario> getByNombre(String nombre);
	public void  save(DisponibilidadDeUsuario disponibilidadDeUsuario);
	public void delete(int id);
	public boolean existsById(int id);
	public boolean existsByNombre(String nombre);
}
