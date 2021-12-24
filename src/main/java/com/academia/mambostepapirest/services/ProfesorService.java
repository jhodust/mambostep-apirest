package com.academia.mambostepapirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dao.IProfesorCustomDao;
import com.academia.mambostepapirest.dao.IProfesorDao;
import com.academia.mambostepapirest.dto.ProfesorDto;
import com.academia.mambostepapirest.mapper.IProfesorMapper;

@Service
public class ProfesorService implements IProfesorService{

	@Autowired
	private IProfesorMapper profesorMapper;
	
	@Autowired
	private IProfesorCustomDao profesorCustomDao;
	
	@Override
	public void saveProfesor(ProfesorDto profesorDto) {
		// TODO Auto-generated method st ub
		System.out.println("profesorId: " + profesorDto.getIdPersona());
		System.out.println("profesorId: " + profesorDto.getValorClase());
		System.out.println("profesorId: " + profesorDto.getPagoClasesMes());
		profesorCustomDao.insertProfesor(profesorDto.getIdPersona(), profesorDto.getValorClase(), profesorDto.getPagoClasesMes());
	}

}
