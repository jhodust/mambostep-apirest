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

import com.academia.mambostepapirest.dto.ClaseDto;
import com.academia.mambostepapirest.services.IClaseService;
import com.academia.mambostepapirest.utils.ApiResponseDto;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clases")
public class ClaseRestController {

	@Autowired
	private IClaseService claseService;
	
	@GetMapping(value = "/listar/all")
	public ResponseEntity<?> listarAllClases(){
		return new ResponseEntity<>(claseService.listAllClases(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/listar/active")
	public ResponseEntity<?> listarClases(){
		return new ResponseEntity<>(claseService.listarClasesActivas(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/save", produces = "application/json")
	public ResponseEntity<?> saveClase(@RequestBody ClaseDto claseDto){
		return claseService.saveClase(claseDto);
	}
	
	@GetMapping(value = "/find/{idClase}")
	public ResponseEntity<?> searchClase(@PathVariable Long idClase){
		return ResponseEntity.ok(ApiResponseDto.ok(claseService.findClaseById(idClase)));
	}
}
