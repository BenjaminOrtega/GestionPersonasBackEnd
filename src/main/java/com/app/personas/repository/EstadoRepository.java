package com.app.personas.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.personas.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	@Query(nativeQuery = false,value = "SELECT e FROM Estado e WHERE id_pais = ?1")
	List<Estado> findByPaisIdPais(Long idPais);
}
