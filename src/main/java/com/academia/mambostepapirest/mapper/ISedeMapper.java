package com.academia.mambostepapirest.mapper;

import com.academia.mambostepapirest.entity.Sede;

import java.util.List;

import com.academia.mambostepapirest.dto.SedeDto;

public interface ISedeMapper {

	public Sede convertSedeDtoToSede(SedeDto sedeDto);
	public SedeDto convertSedeToSedeDto(Sede sede);
	public List<SedeDto> convertListSedeToListSedeDto(List<Sede> listSedes);
}
