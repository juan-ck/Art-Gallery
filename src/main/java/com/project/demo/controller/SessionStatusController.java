package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.SessionStatus;
import com.project.demo.service.SessionStatusService;

@RestController
@RequestMapping ("/session-status")
public class SessionStatusController {

	@Autowired
	private SessionStatusService service;
	
	@GetMapping
	private ResponseEntity<List<SessionStatus>> getAllSessionsStatus() {
		return ResponseEntity.ok(service.findAll());
	}
}
