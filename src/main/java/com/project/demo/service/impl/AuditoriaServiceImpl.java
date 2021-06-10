package com.project.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.demo.entity.Auditoria;

public interface AuditoriaServiceImpl {

	public List<Auditoria> list();
	public Optional<Auditoria> getOne(int id);
	public void  save(Auditoria auditoria);
	public void delete(int id);
	public boolean existsById(int id);
}
