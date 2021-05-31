package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.UserAvailability;
import com.project.demo.service.UserAvailabilityService;

@RestController
@RequestMapping("/user-availability")
public class UserAvailabilityController {

	@Autowired
	private UserAvailabilityService service;
	
	@GetMapping
	private ResponseEntity<List<UserAvailability>> getAllUserAvailabilities() {
		return ResponseEntity.ok(service.findAll());
	}
}
