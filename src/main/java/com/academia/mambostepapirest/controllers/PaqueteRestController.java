package com.academia.mambostepapirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.mambostepapirest.dto.PaqueteDto;
import com.academia.mambostepapirest.services.IPaqueteService;

@RestController
@RequestMapping(value = "/paquetes")
public class PaqueteRestController {

	@Autowired
	private IPaqueteService paqueteService;
	
	@GetMapping(value = "/listar")
	public ResponseEntity<?> listarPaquetes(){
		return new ResponseEntity<>(paqueteService.listarPaquetes(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/save", produces = "application/json")
	public ResponseEntity<?> guardarPaquete(@RequestBody PaqueteDto paqueteDto){
		return new ResponseEntity<>(paqueteService.save(paqueteDto), HttpStatus.OK);
	}
}
