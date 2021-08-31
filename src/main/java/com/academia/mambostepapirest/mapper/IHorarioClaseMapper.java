package com.academia.mambostepapirest.mapper;

import java.util.List;

import com.academia.mambostepapirest.dto.HorarioClaseDto;
import com.academia.mambostepapirest.entity.Horario;

public interface IHorarioClaseMapper {

	public HorarioClaseDto convertHorarioClaseToHorarioClaseDto(Horario horario);
	public Horario convertHorarioClaseDtoToHorarioClase(HorarioClaseDto horarioClaseDto);
	public List<HorarioClaseDto> convertListHorarioClaseToListHorarioClaseDto(List<Horario> listHorario);
	public List<Horario> convertListHorarioClaseDtoToListHorarioClase(List<HorarioClaseDto> listHorarioClaseDto);
	public HorarioClaseDto convertObjectToHorarioClaseDto(Object[] object);
	public List<HorarioClaseDto> convertListObjectToListHorarioClaseDto(List<Object[]> result);
	
}
