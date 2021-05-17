package com.app.personas.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.personas.model.Persona;
import com.app.personas.service.PersonaService;

@RestController
@RequestMapping("/personas/")
public class PersonaRest {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping
	private ResponseEntity<List<Persona>> getAllPersona(){
		return ResponseEntity.ok(personaService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Persona> createPersona(@RequestBody Persona persona){
		try {
			Persona newPerson = personaService.save(persona);
			return ResponseEntity.created(new URI("/personas/" + newPerson.getIdPersona())).body(newPerson) ;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
