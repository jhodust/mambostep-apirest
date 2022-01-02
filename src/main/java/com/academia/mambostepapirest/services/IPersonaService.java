package com.academia.mambostepapirest.services;

import com.academia.mambostepapirest.dto.ControlAccesoDto;
import com.academia.mambostepapirest.dto.PersonaDto;
import com.academia.mambostepapirest.dto.ProfesorDto;
import com.academia.mambostepapirest.entity.Persona;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface IPersonaService {

	public List<PersonaDto> listPersonas(Long idSede);
	
	
	public PersonaDto searchPersonaDto(String documento);
	
	public PersonaDto updatePersona(Long idPersona, PersonaDto personaDto);
	
	public PersonaDto searchPersonaByUsername(String username);
	
	public ControlAccesoDto searchAlumnoControlAcceso(String identificacion);
	
	public Persona findPersonaById(Long id);
	
	public ResponseEntity<?> searchPersonaById(Long idPersona);
	
	
}
