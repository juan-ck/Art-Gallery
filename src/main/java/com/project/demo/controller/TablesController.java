package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Tables;
import com.project.demo.service.TablesService;

@RestController
@RequestMapping ("/tables")
public class TablesController {

	@Autowired
	private TablesService service;
	
	@GetMapping
	private ResponseEntity<List<Tables>> getAllTables() {
		return ResponseEntity.ok(service.findAll());
	}
}
