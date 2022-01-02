package com.academia.mambostepapirest.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academia.mambostepapirest.entity.Clase;
import com.academia.mambostepapirest.entity.Mensualidad;

public interface IMensualidadDao extends JpaRepository<Mensualidad, Long>{

	@Query(value="select count(mc.id)>0  as acceso_clase from mensualidades men"
			+ " left join mensualidad_clases mc on mc.id_mensualidad=men.id"
			+ " where men.id = :idMensualidad"
			+ " and mc.id_clase = :idClase", nativeQuery=true)
	public boolean validateAccesoClase(@Param("idMensualidad") Long idMensualidad, @Param("idClase") Long idClase);
	
	@Query(value="select men from Mensualidad men where men.persona.identificacion = :documento "
			+ " and :currentDate >= men.fechaInicio"
			+ " and :currentDate <= men.fechaFin")
	public Mensualidad findMensualidadActivaByDocumento(@Param("documento") String documento, @Param("currentDate") LocalDate currentDate);
}
