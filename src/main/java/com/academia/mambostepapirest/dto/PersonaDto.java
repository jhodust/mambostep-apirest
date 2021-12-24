package com.academia.mambostepapirest.dto;

import java.time.LocalDate;
import java.util.Date;


import com.academia.mambostepapirest.entity.Sede;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {

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
	
	private boolean profesor;
	
	private boolean alumno;
	
	private String tipoPersona;
}
