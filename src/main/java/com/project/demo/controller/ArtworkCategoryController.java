package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.ArtworkCategory;
import com.project.demo.service.ArtworkCategoryService;

@RestController
@RequestMapping ("/artwork-category")
public class ArtworkCategoryController {

	@Autowired
	private ArtworkCategoryService service;
	
	@GetMapping
	private ResponseEntity<List<ArtworkCategory>> getAllArtworkCategories() {
		return ResponseEntity.ok(service.findAll());
	}
}
