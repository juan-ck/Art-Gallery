package com.project.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.demo.entity.Ventas;

public interface VentasServiceImpl {

	public List<Ventas> list();
	public Optional<Ventas> getOne(int id);
	public void  save(Ventas venta);
	public void delete(int id);
	public boolean existsById(int id);
}
