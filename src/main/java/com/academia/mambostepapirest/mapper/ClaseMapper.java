package com.academia.mambostepapirest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dto.ClaseDto;
import com.academia.mambostepapirest.entity.Clase;
import com.academia.mambostepapirest.entity.Profesor;
import com.academia.mambostepapirest.entity.Sede;

@Component
public class ClaseMapper implements IClaseMapper {

	@Autowired
	private IHorarioClaseMapper horarioClaseMapper;
	
	@Override
	public ClaseDto convertClaseToClaseDto(Clase clase) {
		// TODO Auto-generated method stub
		ClaseDto dto= new ClaseDto();
		dto.setId(clase.getId());
		dto.setNombre(clase.getNombre());
		dto.setNombreProfesor(clase.getProfesor().getNombre());
		dto.setIdProfesor(clase.getProfesor().getId());
		dto.setStatus(clase.isStatus());
		dto.setIdSede(clase.getSede().getId());
		dto.setSede(clase.getSede().getNombre());
		dto.setListHorarioClase(horarioClaseMapper.convertListHorarioClaseToListHorarioClaseDto(clase.getHorario()));
		return dto;
	}

	@Override
	public Clase convertClaseDtoToClase(ClaseDto claseDto, Profesor profesor, Sede sede) {
		// TODO Auto-generated method stub
		
		Clase clase= new Clase();
		clase.setId(claseDto.getId());
		clase.setNombre(claseDto.getNombre());
		clase.setStatus(claseDto.isStatus());
		clase.setProfesor(profesor);
		clase.setSede(sede);
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

	

}
