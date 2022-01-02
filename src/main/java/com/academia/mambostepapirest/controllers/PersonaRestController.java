package com.academia.mambostepapirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academia.mambostepapirest.dto.PersonaDto;
import com.academia.mambostepapirest.services.IPersonaService;
import com.academia.mambostepapirest.utils.ApiResponseDto;

@RestController
@RequestMapping(value = "/personas")
public class PersonaRestController {

	@Autowired
	private IPersonaService personaService;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<?> listPersonas(@RequestParam(name = "idSede",required = false) Long idSede){
		return new ResponseEntity<>(personaService.listPersonas(idSede), HttpStatus.OK); 
	}
	
	
	
	@GetMapping(value = "/search/{documento}")
	public ResponseEntity<?> consultarDatos(@PathVariable String documento) {
		return new ResponseEntity<>(ApiResponseDto.ok(personaService.searchPersonaDto(documento)), HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<?> actualizar(@PathVariable("id") Long idPersona, @RequestBody PersonaDto personaDto) {
		return new ResponseEntity<>(personaService.updatePersona(idPersona, personaDto), HttpStatus.OK);
	  }
	
	@GetMapping(value = "/find/{idPersona}")
	public ResponseEntity<?> findPersonaById(@PathVariable("idPersona") Long idPersona){
		return personaService.searchPersonaById(idPersona);
	}
}
