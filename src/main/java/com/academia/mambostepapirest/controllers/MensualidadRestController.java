package com.academia.mambostepapirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academia.mambostepapirest.dto.MensualidadDto;
import com.academia.mambostepapirest.services.IMensualidadService;

@RestController
@RequestMapping(value = "/mensualidad")
public class MensualidadRestController {

	@Autowired
	private IMensualidadService mensualidadService;
	
	@PostMapping(value = "/registrar")
	public void registrarPagoMensualidad(@RequestBody MensualidadDto mensualidadDto) {
		mensualidadService.registrarMensualidad(mensualidadDto);
	}
	
	@GetMapping(value = "/searchLast/{documento}")
	public ResponseEntity<?> consultarHistoricoMensualidades(@PathVariable String documento) {
		return new ResponseEntity<>(mensualidadService.consultarHistoricoAlumno(documento), HttpStatus.OK);
	}
}
