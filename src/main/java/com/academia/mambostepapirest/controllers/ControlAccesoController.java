package com.academia.mambostepapirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.academia.mambostepapirest.services.IPersonaService;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/controlAcceso")
public class ControlAccesoController {

	@Autowired
	private IPersonaService personaService;
	
	@GetMapping(value = "/searchAlumno/{identificacion}")
	public ResponseEntity<?> consultaAlumnoAcceso(@PathVariable String identificacion){
		return new ResponseEntity<>(personaService.searchAlumnoControlAcceso(identificacion), HttpStatus.OK);
	}
}
