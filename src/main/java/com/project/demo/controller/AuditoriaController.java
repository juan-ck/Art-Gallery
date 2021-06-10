package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.entity.Auditoria;
import com.project.demo.service.AuditoriaService;

@RestController
@RequestMapping("/auditoria")
@CrossOrigin(origins = "*")
public class AuditoriaController {

	@Autowired
	AuditoriaService service;
	
	@GetMapping("/lista")
    public ResponseEntity<List<Auditoria>> list(){
        List<Auditoria> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
