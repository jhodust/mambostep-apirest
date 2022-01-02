package com.academia.mambostepapirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academia.mambostepapirest.entity.Persona;

public interface IPersonaDao extends JpaRepository<Persona, Long> {

	public Persona findByUsername(String username);
	
	public Persona findByIdentificacion(String documento);
	
	
}
