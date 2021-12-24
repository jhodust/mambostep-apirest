package com.academia.mambostepapirest.services;

import com.academia.mambostepapirest.dto.HorarioClaseDto;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IHorarioClaseService {

	public List<HorarioClaseDto> searchHorarioAlumno(String identificacion);
	
	public ResponseEntity<?> validateHoursClass(String dia, String horaInicio, String horaFin);
 	
}
