package com.app.personas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.personas.entity.Estado;
import com.app.personas.service.EstadoService;

@RestController
@RequestMapping("/estados/")
public class EstadoRest {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("{idPais}")
	private ResponseEntity<List<Estado>> getAllStatesByCountry(@PathVariable Long idPais) {
		return ResponseEntity.ok(estadoService.findByPaisIdPais(idPais));
	}
}
