package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dao.IMensualidadClasesCustomDao;
import com.academia.mambostepapirest.dao.IMensualidadCustomDao;
import com.academia.mambostepapirest.dao.IPersonaCustomDao;
import com.academia.mambostepapirest.dao.IPersonaDao;
import com.academia.mambostepapirest.dto.DetallesAlumnoHistoricoDto;
import com.academia.mambostepapirest.dto.MensualidadDto;

@Service
public class MensualidadServiceImpl implements IMensualidadService {

	@Autowired
	private IPersonaCustomDao personaCustomDao;
	
	@Autowired
	private IMensualidadCustomDao mensualidadCustomDao;
	
	@Autowired
	private IMensualidadClasesCustomDao mensualidadClasesCustomDao;
	
	@Override
	public void registrarMensualidad(MensualidadDto mensualidadDto) {
		// TODO Auto-generated method stub
		mensualidadCustomDao.insertMensualidad(mensualidadDto);
		System.out.println("-----------------------------------------------");
		System.out.println("mensualidadDto: " + mensualidadDto.getId());
		mensualidadClasesCustomDao.insertMensualidadClases(mensualidadDto.getId(), mensualidadDto.getIdsClases());
	}

	@Override
	public List<MensualidadDto> consultarHistoricoAlumno(String documento) {
		// TODO Auto-generated method stub
		
		return mensualidadCustomDao.consultarHistoricoMensualidades(documento);
	}

	@Override
	public void consultarMensualidad(Long idPersona) {
		// TODO Auto-generated method stub

	}

}
