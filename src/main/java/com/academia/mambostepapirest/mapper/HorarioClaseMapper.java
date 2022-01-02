package com.academia.mambostepapirest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dao.IClaseDao;
import com.academia.mambostepapirest.dao.IHorarioClaseDao;
import com.academia.mambostepapirest.dto.HorarioClaseDto;
import com.academia.mambostepapirest.entity.Clase;
import com.academia.mambostepapirest.entity.Horario;
import com.academia.mambostepapirest.error.CustomException;

@Component
public class HorarioClaseMapper implements IHorarioClaseMapper {

	@Autowired
	private IClaseDao claseDao;
	
	@Override
	public HorarioClaseDto convertHorarioClaseToHorarioClaseDto(Horario horario) {
		// TODO Auto-generated method stub
		HorarioClaseDto dto = new HorarioClaseDto();
		dto.setId(horario.getId());
		dto.setDia(horario.getDia());
		dto.setHoraFin(horario.getHoraFin());
		dto.setHoraInicio(horario.getHoraInicio());
		dto.setIdClase(horario.getClase().getId());
		dto.setClase(horario.getClase().getNombre());
		return dto;
	}

	@Override
	public Horario convertHorarioClaseDtoToHorarioClase(HorarioClaseDto horarioClaseDto, Clase clase) {
		// TODO Auto-generated method stub
		Horario horarioClase= new Horario();
		horarioClase.setId(horarioClaseDto.getId());
		horarioClase.setDia(horarioClaseDto.getDia());
		horarioClase.setHoraInicio(horarioClaseDto.getHoraInicio());
		horarioClase.setHoraFin(horarioClaseDto.getHoraFin());
		horarioClase.setClase(clase);
		return horarioClase;
	}

	@Override
	public List<HorarioClaseDto> convertListHorarioClaseToListHorarioClaseDto(List<Horario> listHorario) {
		// TODO Auto-generated method stub
		List<HorarioClaseDto> listHorarioClaseDto=new ArrayList<HorarioClaseDto>();
		for(Horario horario: listHorario) {
			listHorarioClaseDto.add(this.convertHorarioClaseToHorarioClaseDto(horario));
		}
		return listHorarioClaseDto;
	}

	@Override
	public List<Horario> convertListHorarioClaseDtoToListHorarioClase(List<HorarioClaseDto> listHorarioClaseDto, Clase clase) {
		// TODO Auto-generated method stub
		List<Horario> listHorarioClase=new ArrayList<Horario>();
		for(HorarioClaseDto horarioClaseDto: listHorarioClaseDto) {
			listHorarioClase.add(this.convertHorarioClaseDtoToHorarioClase(horarioClaseDto, clase));
		}
		return listHorarioClase;
	}

	@Override
	public HorarioClaseDto convertObjectToHorarioClaseDto(Object[] object) {
		// TODO Auto-generated method stub
		HorarioClaseDto dto = new HorarioClaseDto();
		dto.setId(Long.parseLong(String.valueOf(object[0])));
		dto.setDia(String.valueOf(object[1]));
		dto.setHoraInicio(String.valueOf(object[2]));
		dto.setHoraFin(String.valueOf(object[3]));
		dto.setIdClase(Long.parseLong(String.valueOf(object[4])));
		dto.setClase(String.valueOf(object[5]));
		return dto;
	}

	@Override
	public List<HorarioClaseDto> convertListObjectToListHorarioClaseDto(List<Object[]> result) {
		// TODO Auto-generated method stub
		List<HorarioClaseDto> listHorarioClaseDto = new ArrayList<HorarioClaseDto>();
		for(Object[] obj: result) {
			listHorarioClaseDto.add(this.convertObjectToHorarioClaseDto(obj));
		}
		return listHorarioClaseDto;
	}

}
