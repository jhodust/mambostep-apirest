package com.academia.mambostepapirest.dao;

import com.academia.mambostepapirest.entity.Horario;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IHorarioClaseDao extends JpaRepository<Horario, Long> {

	@Query(value="select count(cl.*) = 0 as available_hours "
			+ "from horario_clase hc "
			+ "join clases cl on hc.id_clase=cl.id "
			+ "where upper(hc.dia)=upper(:dia) and ((:horaInicio between hc.hora_inicio  and hc.hora_fin) or "
			+ "(:horaFin between hc.hora_inicio  and hc.hora_fin)) and cl.status and cl.id_sede = :idSede", nativeQuery=true)
	public boolean validateAvailableHoursClass(@Param("dia") String dia, 
			@Param("horaInicio") String horaInicio, @Param("horaFin") String horaFin, @Param("idSede") Long idSede); 



	@Transactional
	@Modifying
	@Query(value="delete from horario_clase where id_clase = :idClase", nativeQuery=true)
	public void deleteHorarioClaseByClase(@Param("idClase") Long idClase);
}
