package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.ArtworkType;
import com.project.demo.service.ArtworkTypeService;

@RestController
@RequestMapping ("/artwork-type")
public class ArtworkTypeController {

	@Autowired
	private ArtworkTypeService service;
	
	@GetMapping
	private ResponseEntity<List<ArtworkType>> getAllArtworkTypes() {
		return ResponseEntity.ok(service.findAll());
	}
}
