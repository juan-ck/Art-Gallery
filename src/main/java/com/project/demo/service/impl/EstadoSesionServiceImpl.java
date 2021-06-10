package com.project.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.demo.entity.EstadoSesion;

public interface EstadoSesionServiceImpl {

	public List<EstadoSesion> list();
	public Optional<EstadoSesion> getOne(int id);
	public Optional<EstadoSesion> getByNombre(String nombre);
	public void  save(EstadoSesion producto);
	public void delete(int id);
	public boolean existsById(int id);
	public boolean existsByNombre(String nombre);
}
