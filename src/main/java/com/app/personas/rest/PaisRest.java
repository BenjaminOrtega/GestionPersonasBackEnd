package com.app.personas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.personas.model.Pais;
import com.app.personas.service.PaisService;

@RestController
@RequestMapping("/paises/")
public class PaisRest {
	
	@Autowired()
	private PaisService paisService;
	
	@GetMapping
	private ResponseEntity<List<Pais>> getAllCountries() {
		return ResponseEntity.ok(paisService.findAll());
	}	
}
