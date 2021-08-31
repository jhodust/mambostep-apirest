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
	private String cantidadClasesSemana;
	private String precio;
	private boolean status;
}
