package com.project.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.demo.entity.Autor;

public interface AutorServiceImpl {
	public List<Autor> list();
	public Optional<Autor> getOne(int id);
	public Optional<Autor> getByNombre(String nombre);
	public void  save(Autor autor);
	public void delete(int id);
	public boolean existsById(int id);
	public boolean existsByNombre(String nombre);
}
