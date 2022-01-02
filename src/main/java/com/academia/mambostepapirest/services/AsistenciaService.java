package com.academia.mambostepapirest.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dao.IAsistenciaDao;
import com.academia.mambostepapirest.dao.IClaseDictadaDao;
import com.academia.mambostepapirest.entity.Asistencia;
import com.academia.mambostepapirest.entity.ClaseDictada;
import com.academia.mambostepapirest.entity.Mensualidad;
import com.academia.mambostepapirest.entity.Persona;
import com.academia.mambostepapirest.error.CustomException;
import com.academia.mambostepapirest.utils.ApiResponseDto;
import com.academia.mambostepapirest.utils.MessagesError;
import com.academia.mambostepapirest.utils.MessagesSuccess;

@Service
public class AsistenciaService implements IAsistenciaService {

	@Autowired
	private IClaseDictadaService claseDictadaService;
	
	@Autowired
	private IMensualidadService mensualidadService;
	
	@Autowired
	private IAsistenciaDao asistenciaDao;
	
	@Override
	public ResponseEntity<?> tomarAsistencia(String documento, String idSede) {
		// TODO Auto-generated method stub
		ClaseDictada claseActiva=this.claseDictadaService.findClaseActiva(Long.parseLong(idSede));
		Mensualidad mensualidadActiva= mensualidadService.findMensualidadActivaByDocumento(documento);
		System.out.println(claseActiva != null);
		System.out.println(mensualidadActiva != null);
		System.out.println(mensualidadActiva.isHasClasesIlimitadas());
		System.out.println(mensualidadService.validateAccesoClase(mensualidadActiva.getId(), claseActiva.getIdClase()));
		if(mensualidadActiva != null && claseActiva != null && (mensualidadActiva.isHasClasesIlimitadas() || mensualidadService.validateAccesoClase(mensualidadActiva.getId(), claseActiva.getIdClase())))  {
			Asistencia asistencia=this.buildAsistencia(claseActiva, mensualidadActiva.getPersona());
			try {
				asistenciaDao.save(asistencia);
				return ResponseEntity.ok(ApiResponseDto.ok(MessagesSuccess.REGISTRO_ASISTENCIA));
			}catch(Exception e) {
				throw new CustomException(MessagesError.ASISTENCIA_TOMADA_ALUMNO);
			}
			
		}
		return null;
	}
	
	private Asistencia buildAsistencia(ClaseDictada claseDictada, Persona persona) {
		Asistencia asistencia=new Asistencia();
		asistencia.setClaseDictada(claseDictada);
		asistencia.setPersona(persona);
		return asistencia;
	}

}
