package com.academia.mambostepapirest.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academia.mambostepapirest.dto.PersonaDto;
import com.academia.mambostepapirest.entity.Sede;
import com.academia.mambostepapirest.mapper.IPersonaMapper;

@Repository
public class PersonaCustomDao implements IPersonaCustomDao {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private IPersonaMapper personaMapper;
	
	
	@Override
	public List<PersonaDto> listPersonas(Long idSede) {
		// TODO Auto-generated method stub
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT p.id as id_persona, p.nombre, p.identificacion, p.fecha_ingreso, p.fecha_nacimiento, p.instagram, p.telefono,")
			 .append(" p.nombre_acudiente, p.telefono_acudiente, p.parentesco_acudiente, s.id as id_sede, s.nombre as nombre_sede")
			 .append(" from personas  p")
			 .append(" join sedes s on s.id=p.id_sede");
		if(idSede != null) {
			query.append(" where s.id = ?1 ");
		}
		Query q= em.createNativeQuery(query.toString());
		if(idSede != null) {
			q.setParameter(1, idSede);
		}
		List<Object[]> result= q.getResultList();
		
		return personaMapper.convertListObjectToListPersonaDto(result);
	}
	
	@Override
	public PersonaDto  consultarDatosBasicosPersona(String identificacion) {
		// TODO Auto-generated method stub
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT p.id as id_persona, p.nombre, p.identificacion, p.fecha_ingreso, p.fecha_nacimiento, p.instagram, p.telefono,")
			 .append(" COALESCE(p.nombre_acudiente,'') as nombreAcudiente, COALESCE(p.telefono_acudiente,'') as telefonoAcudiente, COALESCE(p.parentesco_acudiente,'') as parentescoAcudiente, s.id as id_sede, s.nombre as nombre_sede")
			 .append(" from personas  p")
			 .append(" join sedes s on s.id=p.id_sede")
			 .append(" where p.identificacion = ?1 ");
		
		Query q= em.createNativeQuery(query.toString());
			q.setParameter(1, identificacion);
		
		List<Object[]> result= q.getResultList();
		if(result.size() == 1) {
			return personaMapper.convertObjectToPersonaDto(result.get(0));
		}
		return null;
	}

}
