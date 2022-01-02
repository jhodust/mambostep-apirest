package com.academia.mambostepapirest.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="clases")
public class Clase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private boolean status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_profesor", foreignKey=@ForeignKey(name = "FK_clase_profesor"))
	private Profesor profesor;

	
	@OneToMany(mappedBy = "clase",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Horario> horario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_sede", foreignKey=@ForeignKey(name = "FK_clase_sede"))
	private Sede sede;
}
