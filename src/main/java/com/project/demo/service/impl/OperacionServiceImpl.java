package com.project.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.demo.entity.Operacion;

public interface OperacionServiceImpl {

	public List<Operacion> list();
	public Optional<Operacion> getOne(int id);
	public Optional<Operacion> getByNombre(String nombre);
	public void  save(Operacion operacion);
	public void delete(int id);
	public boolean existsById(int id);
	public boolean existsByNombre(String nombre);
}
