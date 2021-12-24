package com.academia.mambostepapirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.academia.mambostepapirest.mapper.IAlumnoMapper;
import com.academia.mambostepapirest.dao.IAlumnoCustomDao;
import com.academia.mambostepapirest.dto.AlumnoDto;

@Service
public class AlumnoService implements IAlumnoService {

	@Autowired
	private IAlumnoMapper alumnoMapper;
	
	@Autowired
	private IAlumnoCustomDao alumnoCustomDao;
	
	@Override
	public void saveAlumno(AlumnoDto alumnoDto) {
		// TODO Auto-generated method stub
		alumnoCustomDao.insertAlumno(alumnoDto.getIdPersona());
	}

}
