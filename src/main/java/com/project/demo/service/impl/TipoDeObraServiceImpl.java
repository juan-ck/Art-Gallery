package com.project.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.demo.entity.TipoDeObra;

public interface TipoDeObraServiceImpl {

	public List<TipoDeObra> list();
	public Optional<TipoDeObra> getOne(int id);
	public Optional<TipoDeObra> getByNombre(String nombre);
	public void  save(TipoDeObra tipoDeObra);
	public void delete(int id);
	public boolean existsById(int id);
	public boolean existsByNombre(String nombre);
}
