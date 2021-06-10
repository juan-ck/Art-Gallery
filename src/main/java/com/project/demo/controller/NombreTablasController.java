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

import com.project.demo.dto.Mensaje;
import com.project.demo.dto.NombreTablasDto;
import com.project.demo.entity.NombreTablas;
import com.project.demo.service.NombreTablasService;

@RestController
@RequestMapping("/nombre-tablas")
@CrossOrigin(origins = "*")
public class NombreTablasController {

	@Autowired
	NombreTablasService service;
	
	@GetMapping("/lista")
    public ResponseEntity<List<NombreTablas>> list(){
        List<NombreTablas> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody NombreTablasDto nombreTablasDto){
        if(StringUtils.isBlank(nombreTablasDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(service.existsByNombre(nombreTablasDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        NombreTablas nombreTablas = new NombreTablas(nombreTablasDto.getNombre());
        service.save(nombreTablas);
        return new ResponseEntity(new Mensaje("nombre de tabla creado"), HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody NombreTablasDto nombreTablasDto){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(service.existsByNombre(nombreTablasDto.getNombre()) && service.getByNombre(nombreTablasDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(nombreTablasDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        NombreTablas nombreTablas = service.getOne(id).get();
        nombreTablas.setNombre(nombreTablasDto.getNombre());
        service.save(nombreTablas);
        return new ResponseEntity(new Mensaje("nombre de tabla actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("nombre de tabla eliminado"), HttpStatus.OK);
    }
}
