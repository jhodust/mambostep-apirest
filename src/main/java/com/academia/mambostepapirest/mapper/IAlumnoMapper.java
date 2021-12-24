package com.academia.mambostepapirest.mapper;

import com.academia.mambostepapirest.entity.Alumno;

import com.academia.mambostepapirest.dto.AlumnoDto;

import java.util.List;


public interface IAlumnoMapper {

	public AlumnoDto convertAlumnoToAlumnoDto(Alumno alumno);
	public Alumno convertAlumnoDtoToAlumno(AlumnoDto alumnoDto);
	public List<AlumnoDto> convertListAlumnosToListAlumnosDto(List<Alumno> listAlumnos);
	public List<Alumno> convertListAlumnosDtoToListAlumnos(List<AlumnoDto> listAlumnosDto);
}
