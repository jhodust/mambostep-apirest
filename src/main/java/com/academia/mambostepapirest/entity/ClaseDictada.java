package com.academia.mambostepapirest.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clases_dictadas",uniqueConstraints={
		   @UniqueConstraint(columnNames={"id_clase", "fecha", "clase", "hora", "id_sede"}, name = "UK_clase_impartida")})
public class ClaseDictada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate fecha;
	
	private String hora;
	
	private String clase;
	
	private boolean impartida;
	
	@Column(name="id_clase")
	private Long idClase;
	
	@Column(name="id_sede")
	private Long idSede;
	
	@Column(name="clase_activa")
	private boolean claseActiva;
}
