package com.academia.mambostepapirest.services;

import org.springframework.http.ResponseEntity;

public interface IAsistenciaService {

	public ResponseEntity<?> tomarAsistencia(String documento, String idSede);
}
