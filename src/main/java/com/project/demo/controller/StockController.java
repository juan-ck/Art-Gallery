package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Stock;
import com.project.demo.service.StockService;

@RestController
@RequestMapping ("/stock")
public class StockController {

	@Autowired
	private StockService service;
	
	@GetMapping
	private ResponseEntity<List<Stock>> getStock(){
		return ResponseEntity.ok(service.findAll());
	}
}
