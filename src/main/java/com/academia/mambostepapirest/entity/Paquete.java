package com.academia.mambostepapirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

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
	
	@Nullable
	@Column(name = "cant_clases_estandar_semana")
	private String cantidadClasesEstandarSemana;
	
	@Column(name = "dias_duracion")
	private int diasDuracion;
	
	private String precio;
	
	@Column(name = "has_clases_crew_latina")
	private boolean hasClasesCrewLatina;
	
	@Column(name = "has_clases_crew_urbana")
	private boolean hasClasesCrewUrbano;
	
	@Column(name = "has_clases_ilimitadas")
	private boolean hasClasesIlimitadas;
	
	private boolean status;
	
	@Column(name = "is_venta_publico")
	private boolean isVentaPublico;
}
