package com.academia.mambostepapirest.entity;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

import lombok.Getter;

import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "horario_clase")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Horario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String dia;
	
	@Column(name = "hora_inicio")
	private String horaInicio;
	
	@Column(name = "hora_fin")
	private String horaFin;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_clase", foreignKey=@ForeignKey(name = "FK_horario_clase"))
	private Clase clase;
}
