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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name="personas")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String identificacion;
	
	@Column(name="fecha_ingreso")
	private LocalDate fechaIngreso;
	
	@Column(name="fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	private String instagram;
	
	private String telefono;
	
	@Column(name="nombre_acudiente")
	private String nombreAcudiente;
	
	@Column(name="telefono_acudiente")
	private String telefonoAcudiente;
	
	@Column(name="parentesco_acudiente")
	private String parentescoAcudiente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_sede", foreignKey=@ForeignKey(name = "FK_persona_sede"))
	private Sede sede;
}
