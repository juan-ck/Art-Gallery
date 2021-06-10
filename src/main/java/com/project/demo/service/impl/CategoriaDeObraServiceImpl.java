package com.project.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.demo.entity.CategoriaDeObra;

public interface CategoriaDeObraServiceImpl {

	public List<CategoriaDeObra> list();
	public Optional<CategoriaDeObra> getOne(int id);
	public Optional<CategoriaDeObra> getByNombre(String nombre);
	public void  save(CategoriaDeObra categoriaDeObra);
	public void delete(int id);
	public boolean existsById(int id);
	public boolean existsByNombre(String nombre);
}
