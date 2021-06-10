package com.project.demo.controller;

import java.util.HashSet;
import java.util.Iterator;
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
import com.project.demo.dto.VentasDto;
import com.project.demo.entity.Obra;
import com.project.demo.entity.Ventas;
import com.project.demo.security.entity.Rol;
import com.project.demo.service.ObraService;
import com.project.demo.service.VentasService;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "*")
public class VentasController {

	@Autowired 
	VentasService service;
	@Autowired
	ObraService obraService;
	
	@GetMapping("/lista")
    public ResponseEntity<List<Ventas>> list(){
        List<Ventas> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Ventas> getById(@PathVariable("id") int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Ventas venta = service.getOne(id).get();
        return new ResponseEntity(venta, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody VentasDto ventaDto){
        Ventas venta = new Ventas(ventaDto.getValor(), ventaDto.getFecha());
        venta.setUsuario(ventaDto.getUsuario());
        
        Set<Obra> obras = new HashSet<>();
        Object[] arrayObras = (Object[]) ventaDto.getObra().toArray();
        for(int i = 0; i < ventaDto.getObra().size(); i++) {
        	obras.add(obraService.getByNombre(((Obra) arrayObras[i]).getNombre()).get());
        }
        
        
        venta.setObra(obras);
        service.save(venta);
        return new ResponseEntity(new Mensaje("venta creado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody VentasDto ventaDto){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        
        Ventas venta = service.getOne(id).get();
        venta.setValor(ventaDto.getValor());
        venta.setFecha(ventaDto.getFecha());
        
        Set<Obra> obras = new HashSet<>();
        Object[] arrayObras = (Object[]) ventaDto.getObra().toArray();
        for(int i = 0; i < ventaDto.getObra().size(); i++) {
        	obras.add(obraService.getByNombre(((Obra) arrayObras[i]).getNombre()).get());
        }
        
        venta.setObra(obras);
        venta.setUsuario(venta.getUsuario());
        service.save(venta);
        return new ResponseEntity(new Mensaje("venta actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("venta eliminado"), HttpStatus.OK);
    }
}
