package com.app.personas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.personas.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
