package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dao.IHorarioClaseCustomDao;
import com.academia.mambostepapirest.dto.HorarioClaseDto;

@Service
public class HorarioClaseServiceImpl implements IHorarioClaseService {

	@Autowired
	private IHorarioClaseCustomDao horarioClaseCustomDao;
	
	@Override
	public List<HorarioClaseDto> searchHorarioAlumno(String identificacion) {
		// TODO Auto-generated method stub
		return horarioClaseCustomDao.searchHorarioAlumno(identificacion);
	}

}
