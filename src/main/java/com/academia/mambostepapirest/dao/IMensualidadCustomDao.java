package com.academia.mambostepapirest.dao;

import java.util.List;

import com.academia.mambostepapirest.dto.MensualidadDto;

public interface IMensualidadCustomDao {

	public void insertMensualidad(MensualidadDto mensualidadDto);
	
	public List<MensualidadDto> consultarHistoricoMensualidades(String documento);
}
