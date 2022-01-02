package com.academia.mambostepapirest.mapper;

import java.util.List;

import com.academia.mambostepapirest.dto.ProfesorDto;
import com.academia.mambostepapirest.entity.Profesor;
import com.academia.mambostepapirest.entity.Sede;
import com.academia.mambostepapirest.entity.TipoPersona;


public interface IProfesorMapper {

	public ProfesorDto convertProfesorToProfesorDto(Profesor profesor );
	public Profesor convertProfesorDtoToProfesor(ProfesorDto profesorDto, TipoPersona tipoPersona, Sede sede);
	public List<ProfesorDto> convertListProfesorToListProfesoresDto(List<Profesor> listProfesores);
	
}
