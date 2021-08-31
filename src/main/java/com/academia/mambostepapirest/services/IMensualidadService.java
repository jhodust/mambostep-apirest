package com.academia.mambostepapirest.services;

import java.util.List;

import com.academia.mambostepapirest.dto.DetallesAlumnoHistoricoDto;
import com.academia.mambostepapirest.dto.MensualidadDto;

public interface IMensualidadService {

	public void registrarMensualidad(MensualidadDto mensualidadDto);
	
	public List<MensualidadDto> consultarHistoricoAlumno(String documento);
	
	public void consultarMensualidad(Long idPersona);
}
