package com.academia.mambostepapirest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dao.IClaseDao;
import com.academia.mambostepapirest.dao.IHorarioClaseDao;
import com.academia.mambostepapirest.dto.HorarioClaseDto;
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
		dto.setStatus(horario.isStatus());
		dto.setIdClase(horario.getClase().getId());
		dto.setClase(horario.getClase().getNombre());
		return dto;
	}

	@Override
	public Horario convertHorarioClaseDtoToHorarioClase(HorarioClaseDto horarioClaseDto) {
		// TODO Auto-generated method stub
		Horario horario=new Horario();
		horario.setId(horarioClaseDto.getId());
		horario.setDia(horarioClaseDto.getDia());
		horario.setHoraInicio(horario.getHoraInicio());
		horario.setHoraFin(horario.getHoraFin());
		horario.setStatus(horarioClaseDto.isStatus());
		horario.setClase(claseDao.findById(horarioClaseDto.getIdClase()).orElseThrow(() -> new CustomException("no se encontró la clase en la base de datos")));
		
		return horario;
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
	public List<Horario> convertListHorarioClaseDtoToListHorarioClase(List<HorarioClaseDto> listHorarioClaseDto) {
		// TODO Auto-generated method stub
		List<Horario> listHorarioClase=new ArrayList<Horario>();
		for(HorarioClaseDto horarioClaseDto: listHorarioClaseDto) {
			listHorarioClase.add(this.convertHorarioClaseDtoToHorarioClase(horarioClaseDto));
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
		dto.setStatus((boolean) object[4]);
		dto.setIdClase(Long.parseLong(String.valueOf(object[5])));
		dto.setClase(String.valueOf(object[6]));
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
