package com.academia.mambostepapirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.academia.mambostepapirest.entity.Clase;
import com.academia.mambostepapirest.entity.TipoPersona;

public interface ITipoPersonaDao extends JpaRepository<TipoPersona, Long>{

	@Query(value="select * from tipo_persona where UPPER(tipo_persona)=?1", nativeQuery=true)
	public TipoPersona findTipoPersonaByTipo(String tipoPersona);
}
