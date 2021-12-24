package com.academia.mambostepapirest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dto.AlumnoDto;
import com.academia.mambostepapirest.entity.Alumno;

@Component
public class AlumnoMapper implements IAlumnoMapper {

	@Override
	public AlumnoDto convertAlumnoToAlumnoDto(Alumno alumno) {
		// TODO Auto-generated method stub
		AlumnoDto dto= new AlumnoDto();
		dto.setIdPersona(alumno.getId());
		return dto;
	}

	@Override
	public Alumno convertAlumnoDtoToAlumno(AlumnoDto alumnoDto) {
		// TODO Auto-generated method stub
		Alumno alumno=new Alumno();
		alumno.setId(alumnoDto.getIdPersona());
		return alumno;
	}

	@Override
	public List<AlumnoDto> convertListAlumnosToListAlumnosDto(List<Alumno> listAlumnos) {
		// TODO Auto-generated method stub
		List<AlumnoDto> listAlumnosDto=new ArrayList<AlumnoDto>();
		for(Alumno alumno: listAlumnos) {
			AlumnoDto dto=new AlumnoDto();
			dto.setIdPersona(alumno.getId());
			listAlumnosDto.add(dto);
		}
		return listAlumnosDto;
	}

	@Override
	public List<Alumno> convertListAlumnosDtoToListAlumnos(List<AlumnoDto> listAlumnosDto) {
		// TODO Auto-generated method stub
		List<Alumno> listAlumnos=new ArrayList<Alumno>();
		for(AlumnoDto alumnoDto: listAlumnosDto) {
			Alumno alumno=new Alumno();
			alumno.setId(alumnoDto.getIdPersona());
			listAlumnos.add(alumno);
		}
		return listAlumnos;
	}

}
