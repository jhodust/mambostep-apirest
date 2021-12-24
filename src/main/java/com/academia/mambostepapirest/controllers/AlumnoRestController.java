package com.academia.mambostepapirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;

import com.academia.mambostepapirest.dto.AlumnoDto;

import com.academia.mambostepapirest.services.IAlumnoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.mambostepapirest.dto.ProfesorDto;
import com.academia.mambostepapirest.services.IProfesorService;

@RestController
@RequestMapping(value = "/personas/alumno")
public class AlumnoRestController {

	@Autowired
	private IAlumnoService alumnoService;
	
	@PostMapping(value = "/save", produces = "application/json")
	public ResponseEntity<?> saveAlumno(@RequestBody AlumnoDto dto){
		alumnoService.saveAlumno(dto);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}
