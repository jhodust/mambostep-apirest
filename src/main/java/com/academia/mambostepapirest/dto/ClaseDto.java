package com.academia.mambostepapirest.dto;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClaseDto {

	private Long id;
	private String nombre;
	private boolean status;
}
