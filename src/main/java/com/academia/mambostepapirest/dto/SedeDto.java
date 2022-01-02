package com.academia.mambostepapirest.dto;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SedeDto {

	private Long id;
	private String nombre;
	private String direccion;
}
