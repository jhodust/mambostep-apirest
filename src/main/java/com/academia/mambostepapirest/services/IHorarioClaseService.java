package com.academia.mambostepapirest.services;

import com.academia.mambostepapirest.dto.HorarioClaseDto;
import com.academia.mambostepapirest.entity.Clase;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IHorarioClaseService {

	public List<HorarioClaseDto> searchHorarioAlumno(String identificacion);
	
	public ResponseEntity<?> validateHoursClass(String dia, String horaInicio, String horaFin, Long idSede);
	
	public void saveHorarioClase(List<HorarioClaseDto>  horarioClaseDto, Clase clase);
	
	public void deleteHorarioClase(Long idClase);
 	
}
