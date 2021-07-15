package com.app.personas.model;



import lombok.Data;

@Data
public class PersonaModel {
	
	private Long idPersona;
	
	private String nombre;
	
	private String apellido;
	
	private int edad;
	
	private Long pais;
	
	private Long estado;
}
