package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.UserType;
import com.project.demo.service.UserTypeService;

@RestController
@RequestMapping("/user-type")
public class UserTypeController {

	@Autowired
	private UserTypeService service;
	
	@GetMapping
	private ResponseEntity<List<UserType>> getAllUserTypes() {
		return ResponseEntity.ok(service.findAll());
	}
}
