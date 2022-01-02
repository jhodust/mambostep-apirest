package com.academia.mambostepapirest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academia.mambostepapirest.dto.HorarioClaseDto;
import com.academia.mambostepapirest.mapper.IHorarioClaseMapper;

@Repository
public class HorarioClaseCustomDao implements IHorarioClaseCustomDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private IHorarioClaseMapper horarioClaseMapper;
	
	@Override
	public List<HorarioClaseDto> searchHorarioAlumno(String identificacion) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("select hc.id as idHorario, hc.dia, hc.hora_inicio, hc.hora_fin,")
		.append("  cla.id as idClase, cla.nombre from mensualidades men")
		.append(" join mensualidad_clases mc on men.id=mc.id_mensualidad")
		.append(" join personas per on men.id_persona=per.id")
		.append(" join clases cla on mc.id_clase=cla.id")
		.append(" join horario_clase hc on cla.id=hc.id_clase")
		.append(" where men.fecha_fin >(select now()) and per.identificacion = ?1");
		
		Query q= entityManager.createNativeQuery(sb.toString());
		q.setParameter(1, identificacion);
	
		List<Object[]> result=q.getResultList();
		return horarioClaseMapper.convertListObjectToListHorarioClaseDto(result);
	}

	

}
