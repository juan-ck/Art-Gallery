package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Billing;
import com.project.demo.service.BillingService;

@RestController
@RequestMapping ("/billing")
public class BillingController {

	@Autowired
	private BillingService service;
	
	@GetMapping
	private ResponseEntity<List<Billing>> getAllBillings() {
		return ResponseEntity.ok(service.findAll());
	}
}
