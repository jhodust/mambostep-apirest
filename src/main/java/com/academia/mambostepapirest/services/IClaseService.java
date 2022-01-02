package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.academia.mambostepapirest.dto.ClaseDto;

public interface IClaseService {

	public List<ClaseDto> listAllClases();
	public List<ClaseDto> listarClasesActivas();
	
	public ResponseEntity<?> saveClase(ClaseDto dto);
	
	public ClaseDto findClaseById(Long idClase);
}
