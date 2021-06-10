package com.project.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.demo.entity.NombreTablas;

public interface NombreTablasServiceImpl {

	public List<NombreTablas> list();
	public Optional<NombreTablas> getOne(int id);
	public Optional<NombreTablas> getByNombre(String nombre);
	public void  save(NombreTablas nombreTablas);
	public void delete(int id);
	public boolean existsById(int id);
	public boolean existsByNombre(String nombre);
}
