package com.academia.mambostepapirest.services;

import com.academia.mambostepapirest.dto.ControlAccesoDto;
import com.academia.mambostepapirest.dto.PersonaDto;

import java.util.List;

import org.springframework.stereotype.Service;


public interface IPersonaService {

	public List<PersonaDto> listPersonas(Long idSede);
	
	public PersonaDto savePersona(PersonaDto dto);
	
	public PersonaDto searchPersona(String documento);
	
	public PersonaDto updatePersona(Long idPersona, PersonaDto personaDto);
	
	public PersonaDto searchPersonaByUsername(String username);
	
	public ControlAccesoDto searchAlumnoControlAcceso(String identificacion);
}
