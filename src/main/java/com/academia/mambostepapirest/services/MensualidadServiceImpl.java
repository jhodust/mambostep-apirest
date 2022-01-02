package com.academia.mambostepapirest.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dao.IMensualidadClasesCustomDao;
import com.academia.mambostepapirest.dao.IMensualidadCustomDao;
import com.academia.mambostepapirest.dao.IMensualidadDao;
import com.academia.mambostepapirest.dao.IPersonaCustomDao;
import com.academia.mambostepapirest.dao.IPersonaDao;
import com.academia.mambostepapirest.dto.DetallesAlumnoHistoricoDto;
import com.academia.mambostepapirest.dto.MensualidadDto;
import com.academia.mambostepapirest.entity.Mensualidad;
import com.academia.mambostepapirest.mapper.IMensualidadMapper;
import com.academia.mambostepapirest.utils.ApiResponseDto;
import com.academia.mambostepapirest.utils.MessagesSuccess;
import com.academia.mambostepapirest.utils.holiday.Fechas;

@Service
public class MensualidadServiceImpl implements IMensualidadService {

	@Autowired
	private IPersonaCustomDao personaCustomDao;
	
	@Autowired
	private IMensualidadCustomDao mensualidadCustomDao;
	
	@Autowired
	private IMensualidadDao mensualidadDao;
	
	@Autowired
	private IMensualidadClasesCustomDao mensualidadClasesCustomDao;
	
	@Autowired
	private IMensualidadMapper mensualidadMapper;
	
	@Autowired
	private IPersonaService personaService;
	
	@Override
	public ResponseEntity<?> registrarMensualidad(MensualidadDto mensualidadDto) {
		// TODO Auto-generated method stub
		
		Mensualidad mensualidad= mensualidadMapper.convertMensualidadDtoToMensualidad(mensualidadDto, personaService.findPersonaById(mensualidadDto.getIdPersona()));
		mensualidadDao.save(mensualidad);
		System.out.println("-----------------------------------------------");
		System.out.println("mensualidadId: " + mensualidad.getId());
		mensualidadClasesCustomDao.insertMensualidadClases(mensualidad.getId(), mensualidadDto.getIdsClases());
		return ResponseEntity.ok(ApiResponseDto.ok(MessagesSuccess.REGISTRO_MENSUALIDAD));
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

	@Override
	public String generateFechaFinMensualidad(String fechaInicioMensualidad, String diasHabilesMensualidad) {
		// TODO Auto-generated method stub
		return Fechas.calculateFechaFinMensualidad(fechaInicioMensualidad, diasHabilesMensualidad);
	}

	@Override
	public boolean validateAccesoClase(Long idMensualidad, Long idClase) {
		// TODO Auto-generated method stub
		return mensualidadDao.validateAccesoClase(idMensualidad, idClase);
	}

	@Override
	public Mensualidad findMensualidadActivaByDocumento(String documento) {
		// TODO Auto-generated method stub
		return mensualidadDao.findMensualidadActivaByDocumento(documento, LocalDate.now());
	}

}
