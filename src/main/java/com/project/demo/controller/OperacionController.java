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
import com.project.demo.dto.OperacionDto;
import com.project.demo.entity.Operacion;
import com.project.demo.service.OperacionService;

@RestController
@RequestMapping("/operacion")
@CrossOrigin(origins = "*")
public class OperacionController {

	@Autowired
	OperacionService service;
	
	@GetMapping("/lista")
    public ResponseEntity<List<Operacion>> list(){
        List<Operacion> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OperacionDto operacionDto){
        if(StringUtils.isBlank(operacionDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(service.existsByNombre(operacionDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Operacion operacion = new Operacion(operacionDto.getNombre());
        service.save(operacion);
        return new ResponseEntity(new Mensaje("operacion creado"), HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody OperacionDto operacionDto){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(service.existsByNombre(operacionDto.getNombre()) && service.getByNombre(operacionDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(operacionDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Operacion operacion = service.getOne(id).get();
        operacion.setNombre(operacionDto.getNombre());
        service.save(operacion);
        return new ResponseEntity(new Mensaje("operacion actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("operacion eliminado"), HttpStatus.OK);
    }
}
