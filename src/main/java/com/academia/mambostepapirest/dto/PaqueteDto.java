package com.academia.mambostepapirest.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaqueteDto {

	private Long id;
	private String nombre;
	private String cantidadClasesEstandarSemana;
	private String precio;
	private boolean hasClasesCrewLatina;
	private boolean hasClasesCrewUrbano;
	private boolean status;
	private boolean isVentaPublico;
	
	
	
	
}
