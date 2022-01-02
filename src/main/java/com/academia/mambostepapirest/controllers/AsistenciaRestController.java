package com.academia.mambostepapirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.mambostepapirest.services.IAsistenciaService;

@RestController
@RequestMapping(value = "/asistencia")
public class AsistenciaRestController {

	@Autowired
	private IAsistenciaService asistenciaService;
	
	@GetMapping(value="/{idSede}/{documento}")
	public ResponseEntity<?> tomarAsistencia(@PathVariable("idSede") String idSede,
			@PathVariable("documento") String documento){
		return asistenciaService.tomarAsistencia(documento, idSede);
	}
}
