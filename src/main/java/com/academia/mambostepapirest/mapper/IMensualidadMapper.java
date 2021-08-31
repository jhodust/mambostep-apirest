package com.academia.mambostepapirest.mapper;

import java.util.List;

import com.academia.mambostepapirest.dto.MensualidadDto;
import com.academia.mambostepapirest.entity.Mensualidad;

public interface IMensualidadMapper {

	
	public MensualidadDto convertMensualidadToMensualidadDto(Mensualidad mensualidad);
	
	public Mensualidad convertMensualidadDtoToMensualidad(MensualidadDto mensualidadDto);
	
	public List<MensualidadDto>convertListMensualidadesToListMensualidadesDto(List<Mensualidad> listMensualidades);
	
	public List<Mensualidad>convertListMensualidadesDtoToListMensualidades(List<MensualidadDto> listMensualidadesDto);
	
	public List<MensualidadDto> convertListObjectToListMensualidadDto(List<Object[]> listObject);
	
	public MensualidadDto convertObjectToMensualidadDto(Object[] object);
	
}
