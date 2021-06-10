package com.project.demo.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.dto.CategoriaDeObraDto;
import com.project.demo.dto.Mensaje;
import com.project.demo.entity.CategoriaDeObra;
import com.project.demo.entity.TipoDeObra;
import com.project.demo.service.CategoriaDeObraService;

@RestController
@RequestMapping("/categoria-de-obra")
@CrossOrigin(origins = "*")
public class CategoriaDeObraController {

	@Autowired
	CategoriaDeObraService service;
	
	@GetMapping("/lista")
    public ResponseEntity<List<CategoriaDeObra>> list(){
        List<CategoriaDeObra> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	@GetMapping("/detail/{id}")
    public ResponseEntity<TipoDeObra> getById(@PathVariable("id") int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        CategoriaDeObra categoria = service.getOne(id).get();
        return new ResponseEntity(categoria, HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CategoriaDeObraDto categoriaDeObraDto){
        if(StringUtils.isBlank(categoriaDeObraDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(service.existsByNombre(categoriaDeObraDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        CategoriaDeObra categoriaDeObra = new CategoriaDeObra(categoriaDeObraDto.getNombre());
        service.save(categoriaDeObra);
        return new ResponseEntity(new Mensaje("categoria creado"), HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody CategoriaDeObraDto categoriaDeObraDto){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(service.existsByNombre(categoriaDeObraDto.getNombre()) && service.getByNombre(categoriaDeObraDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(categoriaDeObraDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        CategoriaDeObra categoriaDeObra = service.getOne(id).get();
        categoriaDeObra.setNombre(categoriaDeObraDto.getNombre());
        service.save(categoriaDeObra);
        return new ResponseEntity(new Mensaje("categoria actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("categoria eliminado"), HttpStatus.OK);
    }
}
