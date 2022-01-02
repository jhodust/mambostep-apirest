package com.academia.mambostepapirest.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dao.IPersonaDao;
import com.academia.mambostepapirest.dto.MensualidadDto;
import com.academia.mambostepapirest.entity.Mensualidad;
import com.academia.mambostepapirest.entity.Persona;
import com.academia.mambostepapirest.error.CustomException;

@Component
public class MensualidadMapper implements IMensualidadMapper {

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	public MensualidadDto convertMensualidadToMensualidadDto(Mensualidad mensualidad) {
		// TODO Auto-generated method stub
		MensualidadDto dto = new MensualidadDto();
		dto.setId(mensualidad.getId());
		dto.setFechaInicio(mensualidad.getFechaInicio());
		dto.setFechaFin(mensualidad.getFechaFin());
		dto.setNombrePaquete(mensualidad.getNombrePaquete());
		dto.setPrecioPaquete(mensualidad.getPrecioPaquete());
		dto.setPrecioPactado(mensualidad.getPrecioPactado());
		dto.setObservaciones(mensualidad.getObservaciones());
		dto.setIdPersona(mensualidad.getPersona().getId());
		dto.setHasClasesIlimitadas(mensualidad.isHasClasesIlimitadas());
		return dto;
	}

	@Override
	public Mensualidad convertMensualidadDtoToMensualidad(MensualidadDto mensualidadDto , Persona persona) {
		// TODO Auto-generated method stub
		Mensualidad mensualidad = new Mensualidad();
		mensualidad.setId(mensualidadDto.getId());
		mensualidad.setFechaInicio((LocalDate)mensualidadDto.getFechaInicio());
		mensualidad.setFechaFin((LocalDate) mensualidadDto.getFechaFin());
		mensualidad.setNombrePaquete(mensualidadDto.getNombrePaquete());
		mensualidad.setPrecioPaquete(mensualidadDto.getPrecioPaquete());
		mensualidad.setPrecioPactado(mensualidadDto.getPrecioPactado());
		mensualidad.setObservaciones(mensualidadDto.getObservaciones());
		mensualidad.setPersona(persona);
		mensualidad.setHasClasesIlimitadas(mensualidadDto.isHasClasesIlimitadas());
		return mensualidad;
	}

	@Override
	public List<MensualidadDto> convertListMensualidadesToListMensualidadesDto(List<Mensualidad> listMensualidades) {
		// TODO Auto-generated method stub
		List<MensualidadDto> listMensualidadesDto = new ArrayList<MensualidadDto>();
		for(Mensualidad mensualidad: listMensualidades) {
			listMensualidadesDto.add(this.convertMensualidadToMensualidadDto(mensualidad));
		}
		return listMensualidadesDto;
	}

	

	@Override
	public List<MensualidadDto> convertListObjectToListMensualidadDto(List<Object[]> listObject) {
		// TODO Auto-generated method stub
		List<MensualidadDto> listMensualidadesDto = new ArrayList<MensualidadDto>();
		for(Object[] object: listObject) {
			listMensualidadesDto.add(this.convertObjectToMensualidadDto(object));
		}
		return listMensualidadesDto;
	}

	@Override
	public MensualidadDto convertObjectToMensualidadDto(Object[] object) {
		// TODO Auto-generated method stub
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println(object[1]);
		
		MensualidadDto dto = new MensualidadDto();
		dto.setId(Long.parseLong(String.valueOf(object[0])));
		dto.setFechaInicio(LocalDate.parse(String.valueOf(object[1]), formatter));
		dto.setFechaFin(LocalDate.parse(String.valueOf(object[2]), formatter));
		dto.setNombrePaquete(String.valueOf(object[3]));
		dto.setPrecioPaquete(String.valueOf(object[4]));
		dto.setPrecioPactado(String.valueOf(object[5]));
		dto.setObservaciones(String.valueOf(object[6]));
		dto.setClases(String.valueOf(object[7]));
		dto.setHasClasesIlimitadas((Boolean) object[8]);
		dto.setIdPersona(Long.parseLong(String.valueOf(object[9])));
		
		return dto;
	}

}
