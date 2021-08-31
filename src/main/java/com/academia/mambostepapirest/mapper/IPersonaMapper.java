package com.academia.mambostepapirest.mapper;

import com.academia.mambostepapirest.dto.PersonaDto;

import com.academia.mambostepapirest.entity.Persona;

import java.util.List;

public interface IPersonaMapper {

	public List<Persona> convertListPersonaDtoToListPersona(List<PersonaDto> listPersonasDto);
	
	public List<PersonaDto> convertListPersonaToListPersonaDto(List<Persona> listPersonas);
	
	public PersonaDto convertPersonaToPersonaDto(Persona persona);
	
	public Persona convertPersonaDtoToPersona(PersonaDto personaDto);
	
	public List<PersonaDto> convertListObjectToListPersonaDto(List<Object[]> listObject);
	
	public PersonaDto convertObjectToPersonaDto(Object[] object);
}
