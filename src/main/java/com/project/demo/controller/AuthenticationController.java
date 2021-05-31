package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Authentication;
import com.project.demo.service.AuthenticationService;

@RestController
@RequestMapping ("/authentication")
public class AuthenticationController {

	@Autowired
	private AuthenticationService service;
	
	@GetMapping
	private ResponseEntity<List<Authentication>> getAllAuthentications() {
		return ResponseEntity.ok(service.findAll());
	}
}
