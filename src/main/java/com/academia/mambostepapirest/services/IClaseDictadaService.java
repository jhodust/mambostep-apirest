package com.academia.mambostepapirest.services;

import com.academia.mambostepapirest.entity.ClaseDictada;

public interface IClaseDictadaService {

	public void insertClaseADictar(String dia, String horaInicio);
	
	public ClaseDictada findClaseActiva(Long idSede);
}
