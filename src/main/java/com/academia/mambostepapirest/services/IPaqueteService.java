package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dto.PaqueteDto;
import com.academia.mambostepapirest.entity.Paquete;

@Service
public interface IPaqueteService {

	public List<PaqueteDto> listarPaquetes();
	
	public ResponseEntity<?> savePaquete(PaqueteDto paqueteDto);
	
	public Paquete findPaqueteById(Long idPaquete);
}
