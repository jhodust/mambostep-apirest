package com.academia.mambostepapirest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dto.ClaseDto;
import com.academia.mambostepapirest.dto.ProfesorDto;
import com.academia.mambostepapirest.entity.Clase;
import com.academia.mambostepapirest.entity.Profesor;

@Component
public class ProfesorMapper implements IProfesorMapper{

	@Override
	public ProfesorDto convertProfesorToProfesorDto(Profesor profesor) {
		// TODO Auto-generated method stub
		ProfesorDto dto = new ProfesorDto();
		dto.setIdPersona(profesor.getId());
		dto.setValorClase(profesor.getValorClase());
		dto.setPagoClasesMes(profesor.getPagoClasesMes());
		return dto;
	}

	@Override
	public Profesor convertProfesorDtoToProfesor(ProfesorDto profesorDto) {
		// TODO Auto-generated method stub
		Profesor profesor = new Profesor();
		profesor.setId(profesorDto.getIdPersona());
		profesor.setValorClase(profesorDto.getValorClase());
		profesor.setPagoClasesMes(profesorDto.getPagoClasesMes());
		return profesor;
	}

	@Override
	public List<ProfesorDto> convertListProfesorToListProfesoresDto(List<Profesor> listProfesores) {
		// TODO Auto-generated method stub
		List<ProfesorDto> listProfesoresDto= new ArrayList<ProfesorDto>(); 
		for(Profesor profesor: listProfesores) {
			listProfesoresDto.add(this.convertProfesorToProfesorDto(profesor));
		}
		return listProfesoresDto;
	}

	@Override
	public List<Profesor> convertListProfesoresDtoToListProfesores(List<ProfesorDto> listProfesoresDto) {
		// TODO Auto-generated method stub
		List<Profesor> listProfesores= new ArrayList<Profesor>(); 
		for(ProfesorDto dto: listProfesoresDto) {
			listProfesores.add(this.convertProfesorDtoToProfesor(dto));
		}
		return listProfesores;
	}

}
