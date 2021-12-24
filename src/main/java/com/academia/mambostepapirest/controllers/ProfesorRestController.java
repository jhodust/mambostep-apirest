package com.academia.mambostepapirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.mambostepapirest.dto.ProfesorDto;
import com.academia.mambostepapirest.services.IProfesorService;

@RestController
@RequestMapping(value = "/personas/profesor")
public class ProfesorRestController {

	@Autowired
	private IProfesorService profesorService;
	
	@PostMapping(value = "/save", produces = "application/json")
	public ResponseEntity<?> saveProfesor(@RequestBody ProfesorDto dto){
		profesorService.saveProfesor(dto);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}