package com.academia.mambostepapirest.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mensualidad_clases")
public class MensualidadClase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_mensualidad", foreignKey=@ForeignKey(name = "FK_mensualidad_clase_mensualidad"))
	private Mensualidad mensualidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_clase", foreignKey=@ForeignKey(name = "FK_mensualidad_clase_clase"))
	private Clase clase;
}
