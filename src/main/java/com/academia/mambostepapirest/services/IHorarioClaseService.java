package com.academia.mambostepapirest.services;

import com.academia.mambostepapirest.dto.HorarioClaseDto;

import java.util.List;

public interface IHorarioClaseService {

	public List<HorarioClaseDto> searchHorarioAlumno(String identificacion);
 	
}
