package com.academia.mambostepapirest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.mambostepapirest.dto.ClaseDto;
import com.academia.mambostepapirest.dto.PaqueteDto;
import com.academia.mambostepapirest.services.IHorarioClaseService;

@RestController
@RequestMapping(value = "/horario")
public class HorarioClaseRestController {

	@Autowired
	private IHorarioClaseService horarioClaseService;
	
	//esto no tiene nada que ver con el comportamiento del controller, debe ser movido
	@GetMapping(value = "/alumno/{identificacion}")
	public ResponseEntity<?> searchHorarioAlumno(@PathVariable String identificacion){
		return new ResponseEntity<>(horarioClaseService.searchHorarioAlumno(identificacion), HttpStatus.OK);
	}
	
	@GetMapping(value = "/validateAvailableHours")
	public ResponseEntity<?> validateAvailableHours(@RequestParam(name = "dia",required = true) String dia,
			@RequestParam(name = "horaInicio",required = true) String horaInicio,
			@RequestParam(name = "horaFin",required = true) String horaFin,
			@RequestParam(name = "idSede",required = true) Long idSede){
		System.out.println("dia: " + dia);
		System.out.println("hora inicio: " + horaInicio);
		System.out.println("horaFin: " + horaFin);
		System.out.println("idSede: " + idSede);
		return horarioClaseService.validateHoursClass(dia, horaInicio, horaFin, idSede);
	}
	
	
	
}
