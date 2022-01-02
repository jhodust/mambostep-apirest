package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.academia.mambostepapirest.dto.DetallesAlumnoHistoricoDto;
import com.academia.mambostepapirest.dto.MensualidadDto;
import com.academia.mambostepapirest.entity.Mensualidad;

public interface IMensualidadService {

	public ResponseEntity<?> registrarMensualidad(MensualidadDto mensualidadDto);
	
	public List<MensualidadDto> consultarHistoricoAlumno(String documento);
	
	public void consultarMensualidad(Long idPersona);
	
	public String generateFechaFinMensualidad(String fechaInicioMensualidad, String diasHabilesMensualidad);
	
	public boolean validateAccesoClase(Long idMensualidad, Long idClase);
	
	public Mensualidad findMensualidadActivaByDocumento(String documento);
}
