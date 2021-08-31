package com.academia.mambostepapirest.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.academia.mambostepapirest.entity.Sede;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallesAlumnoHistoricoDto {
	
	private PersonaDto personaDto;
	
	private List<MensualidadDto> historicoMensualidades;
}
