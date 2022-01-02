package com.academia.mambostepapirest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="asistencias",uniqueConstraints={
		   @UniqueConstraint(columnNames={"id_clase_dictada", "id_persona", "fecha_ingreso"}, name = "UK_asistencia_persona_clase")})
public class Asistencia implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_clase_dictada", foreignKey=@ForeignKey(name = "FK_asistencia_claseDictada"))
	private ClaseDictada claseDictada;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_persona", foreignKey=@ForeignKey(name = "FK_asistencia_persona"))
	private Persona persona;

	@Column(name = "fecha_ingreso")
	private LocalDate fechaIngreso;
	
	@Column(name = "hora_ingreso")
	private LocalTime horaIngreso;
	
	
	@PrePersist
	private void registerFechaHoraIngreso() {
		this.setFechaIngreso(LocalDate.now());
		this.setHoraIngreso(LocalTime.now());
	}
}
