package com.project.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.entity.Auditoria;
import com.project.demo.repository.AuditoriaRepository;
import com.project.demo.service.impl.AuditoriaServiceImpl;

@Service
@Transactional
public class AuditoriaService implements AuditoriaServiceImpl{

	@Autowired
	AuditoriaRepository repository;
	
	@Override
	public List<Auditoria> list() {
		return repository.findAll();
	}

	@Override
	public Optional<Auditoria> getOne(int id) {
		return repository.findById(id);
	}

	@Override
	public void save(Auditoria auditoria) {
		repository.save(auditoria);
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}

	@Override
	public boolean existsById(int id) {
		return repository.existsById(id);
	}

}
