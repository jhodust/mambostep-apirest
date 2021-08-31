package com.academia.mambostepapirest.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="alumnos")
@PrimaryKeyJoinColumn(name="id_persona", foreignKey=@ForeignKey(name = "FK_alumno_persona"))
public class Alumno extends Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
