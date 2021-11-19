package com.academia.mambostepapirest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.mambostepapirest.services.IHorarioClaseService;

@RestController
@RequestMapping(value = "/horario")
public class HorarioClaseRestController {

	@Autowired
	private IHorarioClaseService horarioClaseService;
	
	@GetMapping(value = "/alumno/{identificacion}")
	public ResponseEntity<?> searchHorarioAlumno(@PathVariable String identificacion){
		return new ResponseEntity<>(horarioClaseService.searchHorarioAlumno(identificacion), HttpStatus.OK);
	}
	
}
