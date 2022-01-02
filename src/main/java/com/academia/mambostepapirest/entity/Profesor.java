package com.academia.mambostepapirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="profesores")
@PrimaryKeyJoinColumn(name="id_persona", foreignKey=@ForeignKey(name = "FK_profesor_persona"))
public class Profesor extends Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="valor_clase")
	private double valorClase;
	
	@Column(name="pago_clases_mes")
	private double pagoClasesMes; 

}
