package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.User;
import com.project.demo.service.UserService;

@RestController
@RequestMapping ("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	private ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(service.findAll());
	}
}
