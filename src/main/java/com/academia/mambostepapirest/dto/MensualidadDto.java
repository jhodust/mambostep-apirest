package com.academia.mambostepapirest.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.academia.mambostepapirest.entity.Persona;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MensualidadDto {

	private Long id;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String nombrePaquete;
	private String precioPaquete;
	private String precioPactado;
	private String observaciones;
	private Long idPersona;
	private List<Long> idsClases;
	private String clases;
	private boolean hasClasesIlimitadas;
}
