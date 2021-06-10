package com.project.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.demo.entity.DisponibilidadDeObra;

public interface DisponibilidadDeObraServiceImpl {

	public List<DisponibilidadDeObra> list();
	public Optional<DisponibilidadDeObra> getOne(int id);
	public Optional<DisponibilidadDeObra> getByNombre(String nombre);
	public void  save(DisponibilidadDeObra disponibilidadDeObra);
	public void delete(int id);
	public boolean existsById(int id);
	public boolean existsByNombre(String nombre);
}
