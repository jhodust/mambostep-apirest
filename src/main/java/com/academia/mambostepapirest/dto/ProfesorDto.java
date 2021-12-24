package com.academia.mambostepapirest.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorDto {

	private Long idPersona;
	private double valorClase;
	private double pagoClasesMes; 
}
