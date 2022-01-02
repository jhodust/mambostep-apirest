package com.academia.mambostepapirest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dto.AlumnoDto;
import com.academia.mambostepapirest.dto.PersonaDto;
import com.academia.mambostepapirest.dto.ProfesorDto;
import com.academia.mambostepapirest.entity.Alumno;
import com.academia.mambostepapirest.entity.Profesor;
import com.academia.mambostepapirest.entity.Sede;
import com.academia.mambostepapirest.entity.TipoPersona;
import com.academia.mambostepapirest.entity.TipoPersonas;

@Component
public class AlumnoMapper implements IAlumnoMapper {

	@Override
	public AlumnoDto convertAlumnoToAlumnoDto(Alumno alumno) {
		// TODO Auto-generated method stub
		AlumnoDto dto= new AlumnoDto();
		dto.setId(alumno.getId());
		dto.setNombre(alumno.getNombre());
		dto.setIdentificacion(alumno.getIdentificacion());
		dto.setFechaIngreso(alumno.getFechaIngreso());
		dto.setFechaNacimiento(alumno.getFechaNacimiento());
		dto.setInstagram(alumno.getInstagram());
		dto.setTelefono(alumno.getTelefono());
		dto.setNombreAcudiente(alumno.getNombreAcudiente());
		dto.setTelefonoAcudiente(alumno.getTelefonoAcudiente());
		dto.setParentescoAcudiente(alumno.getParentescoAcudiente());
		dto.setIdSede(alumno.getSede().getId());
		dto.setNombreSede(alumno.getSede().getNombre());
		dto.setTipoPersona(alumno.getTipoPersona().getTipoPersona());
		dto.setProfesor(dto.getTipoPersona().equalsIgnoreCase(TipoPersonas.PROFESOR.toString()));
		dto.setAlumno(dto.getTipoPersona().equalsIgnoreCase(TipoPersonas.ALUMNO.toString()));
		return dto;
		
		
	}
	
	public Alumno convertAlumnoDtoToAlumno(AlumnoDto alumnoDto, TipoPersona tipoPersona, Sede sede) {
		// TODO Auto-generated method stub
		Alumno alumno=new Alumno();
		alumno.setId(alumnoDto.getId());
		alumno.setNombre(alumnoDto.getNombre());
		alumno.setIdentificacion(alumnoDto.getIdentificacion());
		alumno.setFechaIngreso(alumnoDto.getFechaIngreso());
		alumno.setFechaNacimiento(alumnoDto.getFechaNacimiento());
		alumno.setInstagram(alumnoDto.getInstagram());
		alumno.setTelefono(alumnoDto.getTelefono());
		alumno.setNombreAcudiente(alumnoDto.getNombreAcudiente());
		alumno.setTelefonoAcudiente(alumnoDto.getTelefonoAcudiente());
		alumno.setParentescoAcudiente(alumnoDto.getParentescoAcudiente());
		alumno.setTipoPersona(tipoPersona);
		alumno.setSede(sede);
		return alumno;
	}

	

	@Override
	public List<AlumnoDto> convertListAlumnosToListAlumnosDto(List<Alumno> listAlumnos) {
		// TODO Auto-generated method stub
		List<AlumnoDto> listAlumnosDto=new ArrayList<AlumnoDto>();
		for(Alumno alumno: listAlumnos) {
		
			listAlumnosDto.add(this.convertAlumnoToAlumnoDto(alumno));
		}
		return listAlumnosDto;
	}

	
}
