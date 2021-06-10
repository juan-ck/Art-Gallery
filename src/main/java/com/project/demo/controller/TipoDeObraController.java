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
import com.project.demo.dto.TipoDeObraDto;
import com.project.demo.entity.TipoDeObra;
import com.project.demo.service.TipoDeObraService;


@RestController
@RequestMapping("/tipo-de-obra")
@CrossOrigin(origins = "*")
public class TipoDeObraController {

	@Autowired
	TipoDeObraService service;
	
	@GetMapping("/lista")
    public ResponseEntity<List<TipoDeObra>> list(){
        List<TipoDeObra> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<TipoDeObra> getById(@PathVariable("id") int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        TipoDeObra tipoDeObra = service.getOne(id).get();
        return new ResponseEntity(tipoDeObra, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<TipoDeObra> getByNombre(@PathVariable("nombre") String nombre){
        if(!service.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        TipoDeObra tipoDeObra = service.getByNombre(nombre).get();
        return new ResponseEntity(tipoDeObra, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TipoDeObraDto tipoDeObraDto){
        if(StringUtils.isBlank(tipoDeObraDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(service.existsByNombre(tipoDeObraDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        TipoDeObra tipoDeObra = new TipoDeObra(tipoDeObraDto.getNombre());
        service.save(tipoDeObra);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody TipoDeObraDto tipoDeObraDto){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(service.existsByNombre(tipoDeObraDto.getNombre()) && service.getByNombre(tipoDeObraDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(tipoDeObraDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        TipoDeObra tipoDeObra = service.getOne(id).get();
        tipoDeObra.setNombre(tipoDeObraDto.getNombre());
        service.save(tipoDeObra);
        return new ResponseEntity(new Mensaje("tipo de obra actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("tipo de obra eliminado"), HttpStatus.OK);
    }
}
