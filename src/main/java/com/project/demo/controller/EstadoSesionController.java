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

import com.project.demo.dto.EstadoSesionDto;
import com.project.demo.dto.Mensaje;
import com.project.demo.entity.EstadoSesion;
import com.project.demo.service.EstadoSesionService;

@RestController
@RequestMapping("/estado-sesion")
@CrossOrigin(origins = "*")
public class EstadoSesionController {

	@Autowired
	EstadoSesionService service;
	
	@GetMapping("/lista")
    public ResponseEntity<List<EstadoSesion>> list(){
        List<EstadoSesion> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EstadoSesionDto estadoSesionDto){
        if(StringUtils.isBlank(estadoSesionDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(service.existsByNombre(estadoSesionDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        EstadoSesion estadoSesion = new EstadoSesion(estadoSesionDto.getNombre());
        service.save(estadoSesion);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EstadoSesionDto estadoSesionDto){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(service.existsByNombre(estadoSesionDto.getNombre()) && service.getByNombre(estadoSesionDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(estadoSesionDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        EstadoSesion estadoSesion = service.getOne(id).get();
        estadoSesion.setNombre(estadoSesionDto.getNombre());
        service.save(estadoSesion);
        return new ResponseEntity(new Mensaje("estado actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("estado eliminado"), HttpStatus.OK);
    }
}
