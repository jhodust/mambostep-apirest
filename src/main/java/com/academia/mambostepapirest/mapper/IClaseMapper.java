package com.academia.mambostepapirest.mapper;

import java.util.List;

import com.academia.mambostepapirest.dto.ClaseDto;
import com.academia.mambostepapirest.entity.Clase;

public interface IClaseMapper {

	public ClaseDto convertClaseToClaseDto(Clase clase);
	public Clase convertClaseDtoToClase(ClaseDto claseDto);
	public List<ClaseDto> convertListClaseToListClaseDto(List<Clase> listClases);
	public List<Clase> convertListClaseDtoToListClase(List<ClaseDto> listClasesDto);
}
