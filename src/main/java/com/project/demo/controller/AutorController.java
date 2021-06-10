package com.project.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.project.demo.dto.AutorDto;
import com.project.demo.dto.Mensaje;
import com.project.demo.dto.TipoDeObraDto;
import com.project.demo.entity.Autor;
import com.project.demo.entity.Obra;
import com.project.demo.entity.TipoDeObra;
import com.project.demo.security.entity.Rol;
import com.project.demo.service.AutorService;
import com.project.demo.service.ObraService;
import com.project.demo.service.TipoDeObraService;

@RestController
@RequestMapping("/autor")
@CrossOrigin(origins = "*")
public class AutorController {

	@Autowired
	AutorService service;
	@Autowired
	ObraService obraservice;
	
	@GetMapping("/lista")
    public ResponseEntity<List<Autor>> list(){
        List<Autor> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Autor> getById(@PathVariable("id") int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Autor autor = service.getOne(id).get();
        return new ResponseEntity(autor, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Autor> getByNombre(@PathVariable("nombre") String nombre){
        if(!service.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Autor autor = service.getByNombre(nombre).get();
        return new ResponseEntity(autor, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AutorDto autorDto){
        if(StringUtils.isBlank(autorDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(service.existsByNombre(autorDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        Set<Obra> obras = new HashSet<>();
        Object[] arrayObras = (Object[]) autorDto.getObras().toArray();
        for(int i = 0; i < autorDto.getObras().size(); i++) {
        	obras.add(obraservice.getByNombre(((Autor) arrayObras[i]).getNombre()).get());
        }
        
        Autor autor = new Autor(autorDto.getNombre());
        autor.setObras(obras);
        service.save(autor);
        return new ResponseEntity(new Mensaje("autor creado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody AutorDto autorDto){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(service.existsByNombre(autorDto.getNombre()) && service.getByNombre(autorDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(autorDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Set<Obra> obras = new HashSet<>();
        Object[] arrayObras = (Object[]) autorDto.getObras().toArray();
        for(int i = 0; i < autorDto.getObras().size(); i++) {
        	obras.add(obraservice.getByNombre(((Autor) arrayObras[i]).getNombre()).get());
        }
        
        Autor autor = service.getOne(id).get();
        autor.setNombre(autorDto.getNombre());
        autor.setObras(obras);
        service.save(autor);
        return new ResponseEntity(new Mensaje("autor actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("autor eliminado"), HttpStatus.OK);
    }
}
