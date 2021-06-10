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

import com.project.demo.dto.Mensaje;
import com.project.demo.dto.ObraDto;
import com.project.demo.entity.Autor;
import com.project.demo.entity.Obra;
import com.project.demo.service.AutorService;
import com.project.demo.service.ObraService;
import com.project.demo.service.TipoDeObraService;

@RestController
@RequestMapping("/obra")
@CrossOrigin(origins = "*")
public class ObraController {

	@Autowired
	ObraService service;
	@Autowired
	AutorService autorservice;
	
	@GetMapping("/lista")
    public ResponseEntity<List<Obra>> list(){
        List<Obra> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Obra> getById(@PathVariable("id") int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Obra obra = service.getOne(id).get();
        return new ResponseEntity(obra, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Obra> getByNombre(@PathVariable("nombre") String nombre){
        if(!service.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Obra obra = service.getByNombre(nombre).get();
        return new ResponseEntity(obra, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ObraDto obraDto){
        if(StringUtils.isBlank(obraDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(service.existsByNombre(obraDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        Set<Autor> autores = new HashSet<>();
        Object[] arrayAutores = (Object[]) obraDto.getAutores().toArray();
        for(int i = 0; i < obraDto.getAutores().size(); i++) {
        	autores.add(autorservice.getByNombre(((Autor) arrayAutores[i]).getNombre()).get());
        }
        
        Obra obra = new Obra(obraDto.getNombre(), obraDto.getDescripcion(), obraDto.getImagen(), obraDto.getValor(), 
        		obraDto.getCategoria(), obraDto.getTipo(), obraDto.getDisponibilidad());
        obra.setAutores(autores);
        service.save(obra);
        return new ResponseEntity(new Mensaje("autor creado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ObraDto obraDto){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(service.existsByNombre(obraDto.getNombre()) && service.getByNombre(obraDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(obraDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Set<Autor> autores = new HashSet<>();
        Object[] arrayAutores = (Object[]) obraDto.getAutores().toArray();
        for(int i = 0; i < obraDto.getAutores().size(); i++) {
        	autores.add(autorservice.getByNombre(((Autor) arrayAutores[i]).getNombre()).get());
        }
        
        Obra obra = service.getOne(id).get();
        obra.setNombre(obraDto.getNombre());
        obra.setDescripcion(obraDto.getDescripcion());
        obra.setImagen(obraDto.getImagen());
        obra.setValor(obraDto.getValor());
        obra.setCategoria(obra.getCategoria());
        obra.setTipo(obraDto.getTipo());
        obra.setDisponibilidad(obraDto.getDisponibilidad());
        obra.setAutores(autores);
        service.save(obra);
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
