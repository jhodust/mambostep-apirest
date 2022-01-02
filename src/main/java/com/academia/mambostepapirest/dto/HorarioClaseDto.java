package com.academia.mambostepapirest.dto;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorarioClaseDto {

	private Long id;
	private String clase;
	private Long idClase;
	private String dia;
	private String horaInicio;
	private String horaFin;
}
