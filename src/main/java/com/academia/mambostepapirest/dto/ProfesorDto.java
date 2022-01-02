package com.academia.mambostepapirest.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorDto {

	
	private Long id;
	
	private String nombre;
	
	private String identificacion;
	
	private LocalDate fechaIngreso;
	
	private LocalDate fechaNacimiento;
	
	private String instagram;
	
	private String telefono;
	
	private String nombreAcudiente;
	
	private String telefonoAcudiente;
	
	private String parentescoAcudiente;
	
	private Long idSede;
	
	private String nombreSede;
	
	private double valorClase;
	
	private double pagoClasesMes; 
	
	private boolean profesor;
	
	private boolean alumno;
	
	private String tipoPersona;
}
