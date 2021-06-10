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

import com.project.demo.dto.DisponibilidadObraDto;
import com.project.demo.dto.Mensaje;
import com.project.demo.entity.CategoriaDeObra;
import com.project.demo.entity.DisponibilidadDeObra;
import com.project.demo.entity.TipoDeObra;
import com.project.demo.service.DisponibilidadDeObraService;

@RestController
@RequestMapping("/disponibilidad-de-obra")
@CrossOrigin(origins = "*")
public class DisponibilidadDeObraController {

	@Autowired
	DisponibilidadDeObraService service;
	
	@GetMapping("/lista")
    public ResponseEntity<List<DisponibilidadDeObra>> list(){
        List<DisponibilidadDeObra> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	@GetMapping("/detail/{id}")
    public ResponseEntity<TipoDeObra> getById(@PathVariable("id") int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        DisponibilidadDeObra disponibilidad = service.getOne(id).get();
        return new ResponseEntity(disponibilidad, HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DisponibilidadObraDto disponibilidadObraDto){
		if(StringUtils.isBlank(disponibilidadObraDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(service.existsByNombre(disponibilidadObraDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        DisponibilidadDeObra disponibilidadDeObra = new DisponibilidadDeObra(disponibilidadObraDto.getNombre());
        service.save(disponibilidadDeObra);
        return new ResponseEntity(new Mensaje("disponibilidad de obra creado"), HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody DisponibilidadObraDto disponibilidadObraDto){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(service.existsByNombre(disponibilidadObraDto.getNombre()) && service.getByNombre(disponibilidadObraDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(disponibilidadObraDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        DisponibilidadDeObra disponibilidadDeObra = service.getOne(id).get();
        disponibilidadDeObra.setNombre(disponibilidadObraDto.getNombre());
        service.save(disponibilidadDeObra);
        return new ResponseEntity(new Mensaje("disponibilidad de obra actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("disponibilidad de obra eliminado"), HttpStatus.OK);
    }
}
