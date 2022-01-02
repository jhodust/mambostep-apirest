package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dao.IHorarioClaseCustomDao;
import com.academia.mambostepapirest.dao.IHorarioClaseDao;
import com.academia.mambostepapirest.dto.HorarioClaseDto;
import com.academia.mambostepapirest.entity.Clase;
import com.academia.mambostepapirest.entity.Horario;
import com.academia.mambostepapirest.mapper.IHorarioClaseMapper;
import com.academia.mambostepapirest.utils.MessagesError;
import com.academia.mambostepapirest.utils.ApiResponseDto;

@Service
public class HorarioClaseServiceImpl implements IHorarioClaseService {

	@Autowired
	private IHorarioClaseCustomDao horarioClaseCustomDao;
	
	@Autowired
	private IHorarioClaseDao horarioClaseDao;
	
	@Autowired
	private IHorarioClaseMapper horarioClaseMapper;
	
	@Override
	public List<HorarioClaseDto> searchHorarioAlumno(String identificacion) {
		// TODO Auto-generated method stub
		return horarioClaseCustomDao.searchHorarioAlumno(identificacion);
	}

	@Override
	public ResponseEntity<?> validateHoursClass(String dia, String horaInicio, String horaFin, Long idSede) {
		// TODO Auto-generated method stub
		boolean isClassAvailable=horarioClaseDao.validateAvailableHoursClass(dia, horaInicio, horaFin, idSede);
		return ResponseEntity.ok(ApiResponseDto.ok(isClassAvailable, !isClassAvailable ? MessagesError.HORARIO_NO_DISPONIBLE : null));
	}

	@Override
	public void saveHorarioClase(List<HorarioClaseDto> listHorarioClaseDto, Clase clase) {
		// TODO Auto-generated method stub
		List<Horario> listHorarioClase=horarioClaseMapper.convertListHorarioClaseDtoToListHorarioClase(listHorarioClaseDto, clase);
		horarioClaseDao.saveAll(listHorarioClase);
	}

	@Override
	public void deleteHorarioClase(Long idClase) {
		// TODO Auto-generated method stub
		horarioClaseDao.deleteHorarioClaseByClase(idClase);
	}

}
