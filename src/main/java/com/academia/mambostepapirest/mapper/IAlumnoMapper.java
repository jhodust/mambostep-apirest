package com.academia.mambostepapirest.mapper;

import com.academia.mambostepapirest.entity.Alumno;
import com.academia.mambostepapirest.entity.Sede;
import com.academia.mambostepapirest.entity.TipoPersona;
import com.academia.mambostepapirest.dto.AlumnoDto;

import java.util.List;


public interface IAlumnoMapper {

	public AlumnoDto convertAlumnoToAlumnoDto(Alumno alumno);
	public Alumno convertAlumnoDtoToAlumno(AlumnoDto alumnoDto, TipoPersona tipoPersona, Sede sede);
	public List<AlumnoDto> convertListAlumnosToListAlumnosDto(List<Alumno> listAlumnos);
}
