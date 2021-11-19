package com.academia.mambostepapirest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ControlAccesoDto {

	private Long id;
	private String nombre;
	private String identificacion;
	private String fechaNacimiento;
	private String fechaIngreso;
	private String instagram;
	private String telefono;
	private String email;
	private boolean mensualidadActiva;
	private String fechaInicioUltimaMensualidad;
	private String fechaFinUltimaMensualidad;
	private String nombrePaquete;
	private List<HorarioClaseDto> horario;
}
