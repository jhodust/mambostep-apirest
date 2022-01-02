package com.academia.mambostepapirest.dto;

import lombok.Setter;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClaseDto {

	private Long id;
	private String nombre;
	private Long idProfesor;
	private String nombreProfesor;
	private List<HorarioClaseDto> listHorarioClase;
	private boolean status;
	private Long idSede;
	private String sede;
}
