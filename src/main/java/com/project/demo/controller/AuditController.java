package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Audit;
import com.project.demo.service.AuditService;

@RestController
@RequestMapping ("/audit")
public class AuditController {

	@Autowired
	private AuditService service;
	
	@GetMapping
	private ResponseEntity<List<Audit>> getAllAudits() {
		return ResponseEntity.ok(service.findAll());
	}
}
