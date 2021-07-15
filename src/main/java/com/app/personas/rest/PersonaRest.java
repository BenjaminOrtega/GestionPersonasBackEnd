package com.app.personas.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.personas.entity.Estado;
import com.app.personas.entity.Pais;
import com.app.personas.entity.Persona;
import com.app.personas.model.PersonaModel;
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
	private ResponseEntity<Persona> createPersona(@RequestBody PersonaModel persona){
		try {
			//PersonaController personaController = new PersonaController();
			Persona personaEntity = new Persona();
			personaEntity.setNombre(persona.getNombre());
			personaEntity.setApellido(persona.getApellido());
			personaEntity.setEdad(persona.getEdad());
			Pais pais = new Pais();
			pais.setIdPais(persona.getPais());
			personaEntity.setPais(pais);
			Estado estado = new Estado();
			estado.setIdEstado(persona.getEstado());
			personaEntity.setEstado(estado);
			
			Persona restEntity = personaService.save(personaEntity);
			
			persona.setIdPersona(restEntity.getIdPersona());
			
			return ResponseEntity.created(new URI("/personas/"+restEntity.getIdPersona())).body(restEntity);
		} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping(value = "delete/{persona}")
	private ResponseEntity<Boolean> eliminarPersona(@PathVariable("persona") Persona persona){
		personaService.delete(persona);
		return ResponseEntity.ok(!(personaService.findById(persona.getIdPersona()) != null));
	}
	


}
