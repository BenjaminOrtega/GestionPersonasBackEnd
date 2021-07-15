package com.app.personas.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPersona;
	
	private String nombre;
	
	private String apellido;
	
	private int edad;
	
	@ManyToOne
	@JoinColumn(name = "id_pais")
	private Pais pais;
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;
	
}
