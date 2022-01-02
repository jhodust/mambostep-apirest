package com.academia.mambostepapirest.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dto.AlumnoDto;
import com.academia.mambostepapirest.dto.ClaseDto;
import com.academia.mambostepapirest.dto.ProfesorDto;
import com.academia.mambostepapirest.entity.Clase;
import com.academia.mambostepapirest.entity.Persona;
import com.academia.mambostepapirest.entity.Profesor;
import com.academia.mambostepapirest.entity.Sede;
import com.academia.mambostepapirest.entity.TipoPersona;
import com.academia.mambostepapirest.entity.TipoPersonas;

@Component
public class ProfesorMapper implements IProfesorMapper{

	@Override
	public ProfesorDto convertProfesorToProfesorDto(Profesor profesor) {
		// TODO Auto-generated method stub

		ProfesorDto dto= new ProfesorDto();
		dto.setId(profesor.getId());
		dto.setNombre(profesor.getNombre());
		dto.setIdentificacion(profesor.getIdentificacion());
		dto.setFechaIngreso(profesor.getFechaIngreso());
		dto.setFechaNacimiento(profesor.getFechaNacimiento());
		dto.setInstagram(profesor.getInstagram());
		dto.setTelefono(profesor.getTelefono());
		dto.setNombreAcudiente(profesor.getNombreAcudiente());
		dto.setTelefonoAcudiente(profesor.getTelefonoAcudiente());
		dto.setParentescoAcudiente(profesor.getParentescoAcudiente());
		dto.setIdSede(profesor.getSede().getId());
		dto.setNombreSede(profesor.getSede().getNombre());
		dto.setTipoPersona(profesor.getTipoPersona().getTipoPersona());
		dto.setProfesor(dto.getTipoPersona().equalsIgnoreCase(TipoPersonas.PROFESOR.toString()));
		dto.setAlumno(dto.getTipoPersona().equalsIgnoreCase(TipoPersonas.ALUMNO.toString()));
		dto.setValorClase(profesor.getValorClase());
		dto.setPagoClasesMes(profesor.getPagoClasesMes());
		return dto;
		
	}

	@Override
	public Profesor convertProfesorDtoToProfesor(ProfesorDto profesorDto, TipoPersona tipoPersona, Sede sede) {
		// TODO Auto-generated method stub
		Profesor profesor = new Profesor();
		profesor.setId(profesorDto.getId());
		profesor.setNombre(profesorDto.getNombre());
		profesor.setIdentificacion(profesorDto.getIdentificacion());
		profesor.setFechaIngreso(profesorDto.getFechaIngreso());
		profesor.setFechaNacimiento(profesorDto.getFechaNacimiento());
		profesor.setInstagram(profesorDto.getInstagram());
		profesor.setTelefono(profesorDto.getTelefono());
		profesor.setNombreAcudiente(profesorDto.getNombreAcudiente());
		profesor.setTelefonoAcudiente(profesorDto.getTelefonoAcudiente());
		profesor.setParentescoAcudiente(profesorDto.getParentescoAcudiente());
		profesor.setValorClase(profesorDto.getValorClase());
		profesor.setPagoClasesMes(profesorDto.getPagoClasesMes());
		profesor.setTipoPersona(tipoPersona);
		profesor.setSede(sede);
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

	

}
