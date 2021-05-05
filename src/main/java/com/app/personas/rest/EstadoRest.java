package com.app.personas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.personas.model.Estado;
import com.app.personas.service.EstadoService;

@RestController
@RequestMapping("/estados/")
public class EstadoRest {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	private ResponseEntity<List<Estado>> getAllStates(){
		return ResponseEntity.ok(estadoService.findAll());
	}
}
