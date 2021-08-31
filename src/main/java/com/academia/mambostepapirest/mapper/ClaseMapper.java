package com.academia.mambostepapirest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dto.ClaseDto;
import com.academia.mambostepapirest.entity.Clase;

@Component
public class ClaseMapper implements IClaseMapper {

	@Override
	public ClaseDto convertClaseToClaseDto(Clase clase) {
		// TODO Auto-generated method stub
		ClaseDto dto= new ClaseDto();
		dto.setId(clase.getId());
		dto.setNombre(clase.getNombre());
		dto.setStatus(clase.isStatus());
		return dto;
	}

	@Override
	public Clase convertClaseDtoToClase(ClaseDto claseDto) {
		// TODO Auto-generated method stub
		Clase clase= new Clase();
		clase.setId(claseDto.getId());
		clase.setNombre(claseDto.getNombre());
		clase.setStatus(claseDto.isStatus());
		return clase;
	}

	@Override
	public List<ClaseDto> convertListClaseToListClaseDto(List<Clase> listClases) {
		// TODO Auto-generated method stub
		List<ClaseDto> listClasesDto= new ArrayList<ClaseDto>(); 
		for(Clase clase: listClases) {
			listClasesDto.add(this.convertClaseToClaseDto(clase));
		}
		return listClasesDto;
		
	}

	@Override
	public List<Clase> convertListClaseDtoToListClase(List<ClaseDto> listClasesDto) {
		// TODO Auto-generated method stub
		List<Clase> listClases= new ArrayList<Clase>(); 
		for(ClaseDto claseDto: listClasesDto) {
			listClases.add(this.convertClaseDtoToClase(claseDto));
		}
		return listClases;
	}

}
