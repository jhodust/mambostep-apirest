package com.academia.mambostepapirest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name="asistencias")
public class Asistencia implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_clase_dicta", foreignKey=@ForeignKey(name = "FK_asistencia_claseDictada"))
	private ClaseDictada claseDictada;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_persona", foreignKey=@ForeignKey(name = "FK_asistencia_persona"))
	private Persona persona;

	@Column(name = "fecha_ingreso")
	private LocalDate fechaIngreso;
}
