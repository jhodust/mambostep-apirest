package com.academia.mambostepapirest.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="mensualidades")
public class Mensualidad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;
	
	@Column(name = "fecha_fin")
	private LocalDate fechaFin;
	
	@Column(name = "nombre_paquete")
	private String nombrePaquete;
	
	@Column(name = "precio_paquete")
	private String precioPaquete;
	
	@Column(name = "precio_pactado")
	private String precioPactado;
	
	private String observaciones;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_persona", foreignKey=@ForeignKey(name = "FK_mensualidad_persona"))
	private Persona persona;
}