package com.project.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.demo.entity.Obra;

public interface ObraServiceImpl {

	public List<Obra> list();
	public Optional<Obra> getOne(int id);
	public Optional<Obra> getByNombre(String nombre);
	public void  save(Obra obra);
	public void delete(int id);
	public boolean existsById(int id);
	public boolean existsByNombre(String nombre);
}
