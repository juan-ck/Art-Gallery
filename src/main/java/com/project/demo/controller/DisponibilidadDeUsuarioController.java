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

import com.project.demo.dto.DisponibilidadUsuarioDto;
import com.project.demo.dto.Mensaje;
import com.project.demo.entity.DisponibilidadDeUsuario;
import com.project.demo.service.DisponibilidadDeUsuarioService;

@RestController
@RequestMapping("/disponibilidad-de-usuario")
@CrossOrigin(origins = "*")
public class DisponibilidadDeUsuarioController {

	@Autowired
	DisponibilidadDeUsuarioService service;
	
	@GetMapping("/lista")
    public ResponseEntity<List<DisponibilidadDeUsuario>> list(){
        List<DisponibilidadDeUsuario> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DisponibilidadUsuarioDto disponibilidadUsuarioDto){
		if(StringUtils.isBlank(disponibilidadUsuarioDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(service.existsByNombre(disponibilidadUsuarioDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        DisponibilidadDeUsuario disponibilidadDeUsuario = new DisponibilidadDeUsuario(disponibilidadUsuarioDto.getNombre());
        service.save(disponibilidadDeUsuario);
        return new ResponseEntity(new Mensaje("disponibilidadDeUsuario creado"), HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody DisponibilidadUsuarioDto disponibilidadUsuarioDto){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(service.existsByNombre(disponibilidadUsuarioDto.getNombre()) && service.getByNombre(disponibilidadUsuarioDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(disponibilidadUsuarioDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        DisponibilidadDeUsuario disponibilidadDeUsuario = service.getOne(id).get();
        disponibilidadDeUsuario.setNombre(disponibilidadUsuarioDto.getNombre());
        service.save(disponibilidadDeUsuario);
        return new ResponseEntity(new Mensaje("disponibilidadDeUsuario actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("disponibilidadDeUsuario eliminado"), HttpStatus.OK);
    }
}
