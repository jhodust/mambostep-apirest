package com.academia.mambostepapirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.academia.mambostepapirest.services.IClaseService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clases")
public class ClaseRestController {

	@Autowired
	private IClaseService claseService;
	
	@GetMapping(value = "/listar")
	public ResponseEntity<?> listarClases(){
		return new ResponseEntity<>(claseService.listarClases(), HttpStatus.OK);
	}
}
