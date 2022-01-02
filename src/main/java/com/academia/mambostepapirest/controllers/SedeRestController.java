package com.academia.mambostepapirest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.academia.mambostepapirest.services.ISedeService;
import com.academia.mambostepapirest.utils.ApiResponseDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/sede")
public class SedeRestController {

	@Autowired
	private ISedeService sedeService;
	
	@GetMapping(value = "/listar")
	public ResponseEntity<?> listarSedes(){
		return new ResponseEntity<>(ApiResponseDto.ok(sedeService.findAllSedes()), HttpStatus.OK);
	}
}
