package com.academia.mambostepapirest.dao;

import com.academia.mambostepapirest.entity.ClaseDictada;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface IClaseDictadaDao extends JpaRepository<ClaseDictada, Long>{

	@Transactional
	@Modifying
	@Query(value="update clases_dictadas set clase_activa = false", nativeQuery=true)
	public void resetStatusActiveClasesDictada();
	
	@Query(value="select * from clases_dictadas where clase_activa and id_sede = :idSede", nativeQuery=true)
	public ClaseDictada findClaseDictadaByActivaAndSede(@Param("idSede") Long idSede);
}
