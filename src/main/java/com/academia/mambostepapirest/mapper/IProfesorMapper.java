package com.academia.mambostepapirest.mapper;

import java.util.List;

import com.academia.mambostepapirest.dto.ProfesorDto;
import com.academia.mambostepapirest.entity.Profesor;


public interface IProfesorMapper {

	public ProfesorDto convertProfesorToProfesorDto(Profesor profesor);
	public Profesor convertProfesorDtoToProfesor(ProfesorDto profesorDto);
	public List<ProfesorDto> convertListProfesorToListProfesoresDto(List<Profesor> listProfesores);
	public List<Profesor> convertListProfesoresDtoToListProfesores(List<ProfesorDto> listProfesoresDto);
}
