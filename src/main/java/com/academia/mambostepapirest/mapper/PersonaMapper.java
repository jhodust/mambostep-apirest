package com.academia.mambostepapirest.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dao.ISedeDao;
import com.academia.mambostepapirest.dao.ITipoPersonaDao;
import com.academia.mambostepapirest.dto.MensualidadDto;
import com.academia.mambostepapirest.dto.PersonaDto;
import com.academia.mambostepapirest.entity.TipoPersonas;
import com.academia.mambostepapirest.entity.Persona;
import com.academia.mambostepapirest.error.CustomException;

@Component
public class PersonaMapper implements IPersonaMapper {

	@Autowired
	private ISedeDao sedeDao;
	
	@Autowired
	private ITipoPersonaDao tipoPersonaDao;
	
	@Override
	public List<Persona> convertListPersonaDtoToListPersona(List<PersonaDto> listPersonasDto) {
		// TODO Auto-generated method stub
		List<Persona> list=new ArrayList<Persona>();
		for(PersonaDto dto: listPersonasDto) {
			list.add(this.convertPersonaDtoToPersona(dto));
		}
		return list;
	}

	@Override
	public List<PersonaDto> convertListPersonaToListPersonaDto(List<Persona> listPersonas) {
		// TODO Auto-generated method stub
		List<PersonaDto> list=new ArrayList<PersonaDto>();
		for(Persona dto: listPersonas) {
			list.add(this.convertPersonaToPersonaDto(dto));
		}
		return list;
	}

	@Override
	public PersonaDto convertPersonaToPersonaDto(Persona persona) {
		// TODO Auto-generated method stub
		PersonaDto dto= new PersonaDto();
		dto.setId(persona.getId());
		dto.setNombre(persona.getNombre());
		dto.setIdentificacion(persona.getIdentificacion());
		dto.setFechaIngreso(persona.getFechaIngreso());
		dto.setFechaNacimiento(persona.getFechaNacimiento());
		dto.setInstagram(persona.getInstagram());
		dto.setTelefono(persona.getTelefono());
		dto.setNombreAcudiente(persona.getNombreAcudiente());
		dto.setTelefonoAcudiente(persona.getTelefonoAcudiente());
		dto.setParentescoAcudiente(persona.getParentescoAcudiente());
		dto.setIdSede(persona.getSede().getId());
		dto.setNombreSede(persona.getSede().getNombre());
		dto.setTipoPersona(persona.getTipoPersona().getTipoPersona());
		dto.setProfesor(dto.getTipoPersona().equalsIgnoreCase(TipoPersonas.PROFESOR.toString()));
		dto.setAlumno(dto.getTipoPersona().equalsIgnoreCase(TipoPersonas.ALUMNO.toString()));
		return dto;
	}

	@Override
	public Persona convertPersonaDtoToPersona(PersonaDto personaDto) {
		// TODO Auto-generated method stub
		Persona persona= new Persona();
		persona.setId(personaDto.getId());
		persona.setNombre(personaDto.getNombre());
		persona.setIdentificacion(personaDto.getIdentificacion());
		persona.setFechaIngreso(personaDto.getFechaIngreso());
		persona.setFechaNacimiento(personaDto.getFechaNacimiento());
		persona.setInstagram(personaDto.getInstagram());
		persona.setTelefono(personaDto.getTelefono());
		persona.setNombreAcudiente(personaDto.getNombreAcudiente());
		persona.setTelefonoAcudiente(personaDto.getTelefonoAcudiente());
		persona.setParentescoAcudiente(personaDto.getParentescoAcudiente());
		persona.setSede(sedeDao.findById(personaDto.getIdSede()).orElseThrow(() -> new CustomException("no existe la sede en la base de datos")));
		System.out.println("TIPO  a buscar:: " + (personaDto.isAlumno()? TipoPersonas.ALUMNO.toString() : TipoPersonas.PROFESOR.toString()));
		persona.setTipoPersona(tipoPersonaDao.findTipoPersonaByTipo(personaDto.isAlumno()? TipoPersonas.ALUMNO.toString() : TipoPersonas.PROFESOR.toString()));
		return persona;
	}

	@Override
	public List<PersonaDto> convertListObjectToListPersonaDto(List<Object[]> listObject) {
		// TODO Auto-generated method stub
		List<PersonaDto> list=new ArrayList<PersonaDto>();
		for(Object[] object:listObject) {
			list.add(this.convertObjectToPersonaDto(object));
		}
		return list;
	}

	@Override
	public PersonaDto convertObjectToPersonaDto(Object[] object) {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		PersonaDto dto= new PersonaDto();
		dto.setId(Long.parseLong(String.valueOf(object[0])));
		dto.setNombre(String.valueOf(object[1]));
		dto.setIdentificacion(String.valueOf(object[2]));
		dto.setFechaIngreso(LocalDate.parse(String.valueOf(object[3]), formatter));
		dto.setFechaNacimiento(LocalDate.parse(String.valueOf(object[4]), formatter));
		dto.setInstagram(String.valueOf(object[5]));
		dto.setTelefono(String.valueOf(object[6]));
		dto.setNombreAcudiente(String.valueOf(object[7]));
		dto.setTelefonoAcudiente(String.valueOf(object[8]));
		dto.setParentescoAcudiente(String.valueOf(object[9]));
		dto.setIdSede(Long.parseLong(String.valueOf(object[10])));
		dto.setNombreSede(String.valueOf(object[11]));
		return dto;
	}

}
