package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.academia.mambostepapirest.dto.ProfesorDto;
import com.academia.mambostepapirest.entity.Profesor;

public interface IProfesorService {

	public ResponseEntity<?> saveProfesor(ProfesorDto profesorDto);
	
	public ResponseEntity<?> listProfesores();
	
	public Profesor findProfesorById(Long idProfesor);
	
	public ResponseEntity<?> searchProfesorById(Long idProfesor);
}
