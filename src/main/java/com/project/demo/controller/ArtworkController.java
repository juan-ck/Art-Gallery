package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Artwork;
import com.project.demo.service.ArtworkService;

@RestController
@RequestMapping ("/artwork")
public class ArtworkController {

	@Autowired
	private ArtworkService service;
	
	@GetMapping
	private ResponseEntity<List<Artwork>> getArtworks(){
		return ResponseEntity.ok(service.findAll());
	}
}
