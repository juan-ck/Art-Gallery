package com.project.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Artwork;
import com.project.demo.model.ArtworkAvailability;
import com.project.demo.model.ArtworkCategory;
import com.project.demo.model.ArtworkType;
import com.project.demo.model.Author;
import com.project.demo.service.ArtworkAvailabilityService;
import com.project.demo.service.ArtworkCategoryService;
import com.project.demo.service.ArtworkService;
import com.project.demo.service.ArtworkTypeService;
import com.project.demo.service.AuthorService;

@RestController
@RequestMapping ("/api/artwork-list")
public class ArtworkController {

	@Autowired
	private ArtworkService service;
	@Autowired
	private AuthorService service2;
	@Autowired
	private ArtworkCategoryService service3;
	@Autowired
	private ArtworkTypeService service4;
	@Autowired
	private ArtworkAvailabilityService service5;
	
	@GetMapping
	private ResponseEntity<List<Artwork>> getArtworks() throws Exception{
		run();
		return ResponseEntity.ok(service.findAll());
	}
	
	public void run() throws Exception {
		System.out.println("entro");
		ArtworkCategory category = new ArtworkCategory();
		category.setName("surrealista");
		service3.save(category);
		ArtworkType type = new ArtworkType();
		type.setName("pintura");
		service4.save(type);
		ArtworkAvailability availability = new ArtworkAvailability();
		availability.setName("disponible");
		service5.save(availability);
		
		Artwork artwork = new Artwork();
		artwork.setName("La noche estrellada");
		artwork.setPicture("3");
		artwork.setValue(150000);
		artwork.setDescription("jaksldjfklasdjfklajsdklfjaskldjflksad");
		artwork.setArtworkCategory(category);
		artwork.setArtworkType(type);
		artwork.setArtworkAvailability(availability);
		
		Author van = new Author();
		van.setName("Vincent van Gogh");
		
		ArrayList<Author> lista1 = new ArrayList();
		lista1.add(van);
		ArrayList<Artwork> lista2 = new ArrayList();
		lista2.add(artwork);
		
		artwork.setAuthor(lista1);
		van.setStock(lista2);
		
		service.save(artwork);
		service2.save(van);
	}
}
