package com.academia.mambostepapirest.dao;

import java.util.List;

import com.academia.mambostepapirest.dto.PersonaDto;

public interface IPersonaCustomDao {

	public List<PersonaDto> listPersonas(Long idSede);
	
	public PersonaDto  consultarDatosBasicosPersona(String identificacion);
}
