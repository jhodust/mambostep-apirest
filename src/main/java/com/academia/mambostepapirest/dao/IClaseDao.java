package com.academia.mambostepapirest.dao;

import com.academia.mambostepapirest.entity.Clase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IClaseDao extends JpaRepository<Clase, Long>{

	@Query(value="select c.* from clases c where c.status", nativeQuery = true)
	public List<Clase> listarClasesActivas();
	
	@Query(value="select count(cl.*)=0 from clases cl "
			+ "where upper(nombre) = upper(:clase) and cl.id_sede= :idSede and cl.id != :idClase ", nativeQuery=true)
	public boolean validateDuplicateNameClase(@Param("clase") String clase, @Param("idSede") Long idSede,
			@Param("idClase") Long idClase); 
	
	@Query(value="select * from clases cl "
			+ " join horario_clase hc on cl.id=hc.id_clase"
			+ " where UPPER(hc.dia) = UPPER(:dia) and hc.hora_inicio=:horaInicio and cl.status" , nativeQuery=true)
	public List<Clase> findClaseByDiaAndHoraInicio(@Param("dia") String dia, 
			@Param("horaInicio") String horaInicio);
	
}
