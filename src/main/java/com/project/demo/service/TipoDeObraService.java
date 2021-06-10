package com.project.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.entity.TipoDeObra;
import com.project.demo.repository.TipoDeObraRepository;
import com.project.demo.service.impl.TipoDeObraServiceImpl;

@Service
@Transactional
public class TipoDeObraService implements TipoDeObraServiceImpl{

	@Autowired
	TipoDeObraRepository repository;
	
	@Override
	public List<TipoDeObra> list(){
        return repository.findAll();
    }

	@Override
    public Optional<TipoDeObra> getOne(int id){
        return repository.findById(id);
    }

	@Override
    public Optional<TipoDeObra> getByNombre(String nombre){
        return repository.findByNombre(nombre);
    }

	@Override
    public void  save(TipoDeObra tipoDeObra){
    	repository.save(tipoDeObra);
    }

	@Override
    public void delete(int id){
    	repository.deleteById(id);
    }

	@Override
    public boolean existsById(int id){
        return repository.existsById(id);
    }

	@Override
    public boolean existsByNombre(String nombre){
        return repository.existsByNombre(nombre);
    }
}
