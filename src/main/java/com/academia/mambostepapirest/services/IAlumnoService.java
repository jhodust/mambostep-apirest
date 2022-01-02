package com.academia.mambostepapirest.services;

import org.springframework.http.ResponseEntity;

import com.academia.mambostepapirest.dto.AlumnoDto;
import com.academia.mambostepapirest.entity.Alumno;
import com.academia.mambostepapirest.entity.Profesor;

public interface IAlumnoService {

	public ResponseEntity<?> saveAlumno(AlumnoDto alumnoDto);
	
	public ResponseEntity<?> listAlumnos();
	
	public Alumno findAlumnoById(Long idPersona);
	
	public ResponseEntity<?> searchAlumnoById(Long idPersona);
}
