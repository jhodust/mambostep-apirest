package com.academia.mambostepapirest.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dto.PaqueteDto;
import com.academia.mambostepapirest.entity.Paquete;


public interface IPaqueteMapper {

	public PaqueteDto convertPaqueteToPaqueteDto(Paquete paquete);
	public Paquete convertPaqueteDtoToPaquete(PaqueteDto paqueteDto);
	public List<PaqueteDto> convertListPaqueteToListPaqueteDto(List<Paquete> listPaquetes);
	public List<Paquete> convertListPaqueteDtoToListPaquete(List<PaqueteDto> listPaquetesDto);
}
