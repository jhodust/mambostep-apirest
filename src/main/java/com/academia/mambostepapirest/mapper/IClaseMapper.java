package com.academia.mambostepapirest.mapper;

import java.util.List;

import com.academia.mambostepapirest.dto.ClaseDto;
import com.academia.mambostepapirest.entity.Clase;
import com.academia.mambostepapirest.entity.Profesor;
import com.academia.mambostepapirest.entity.Sede;

public interface IClaseMapper {

	public ClaseDto convertClaseToClaseDto(Clase clase);
	public Clase convertClaseDtoToClase(ClaseDto claseDto, Profesor profesor, Sede sede);
	public List<ClaseDto> convertListClaseToListClaseDto(List<Clase> listClases);
}
