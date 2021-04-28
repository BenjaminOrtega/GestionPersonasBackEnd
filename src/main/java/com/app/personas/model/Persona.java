package com.app.personas.model;

import java.io.Serializable;

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
public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPersona;
	
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
