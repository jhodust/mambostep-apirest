package com.academia.mambostepapirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="paquetes")
public class Paquete implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@Column(name = "cant_clases_estandar_semana")
	private String cantidadClasesEstandarSemana;
	
	private String precio;
	
	@Column(name = "has_clases_crew_latina")
	private boolean hasClasesCrewLatina;
	
	@Column(name = "has_clases_crew_urbana")
	private boolean hasClasesCrewUrbano;
	
	private boolean status;
	
	@Column(name = "is_venta_publico")
	private boolean isVentaPublico;
}
