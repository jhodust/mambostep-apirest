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

import com.academia.mambostepapirest.dto.ControlAccesoDto;
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

	@Override
	public ControlAccesoDto consultarControlAccesoAlumno(String identificacion) {
		// TODO Auto-generated method stub
		
		StringBuilder query = new StringBuilder();
		query.append("select per.id, per.nombre, per.identificacion, per.fecha_nacimiento, ")
			 .append(" per.fecha_ingreso, per.instagram, per.telefono, per.email,  count(sq.*) > 0, ")
			 .append("  sq.fecha_inicio, sq.fecha_fin, sq.nombre_paquete")
			 .append(" from personas  per ")
			 .append(" left join ( select men.id_persona, men.fecha_inicio, men.fecha_fin, men.nombre_paquete")
			 .append(" from personas p ")
			 .append(" join mensualidades men on men.id_persona=p.id")
			 .append(" where p.identificacion=?1 and men.fecha_fin >= (select now())) as sq")
			 .append(" on sq.id_persona=per.id")
			 .append(" where per.identificacion=?1")
			 .append(" group by per.id, sq.fecha_inicio, sq.fecha_fin, sq.nombre_paquete ")
			 .append(" order by sq.fecha_fin desc");
		
		Query q= em.createNativeQuery(query.toString());
		q.setParameter(1, identificacion);
	
		List<Object[]> result= q.getResultList();
		if(result.size() == 1) {
			Object[] persona= result.get(0);
			ControlAccesoDto dto= new ControlAccesoDto();
			dto.setId(Long.parseLong(String.valueOf(persona[0])));
			dto.setNombre(String.valueOf(persona[1]));
			dto.setIdentificacion(String.valueOf(persona[2]));
			dto.setFechaNacimiento(String.valueOf(persona[3]));
			dto.setFechaIngreso(String.valueOf(persona[4]));
			dto.setInstagram(String.valueOf(persona[5]));
			dto.setTelefono(String.valueOf(persona[6]));
			dto.setEmail(String.valueOf(persona[7]));
			dto.setMensualidadActiva((boolean) persona[8]);
			dto.setFechaInicioUltimaMensualidad(persona[9] != null ? String.valueOf(persona[9]) : null);
			dto.setFechaFinUltimaMensualidad(persona[10] != null ? String.valueOf(persona[10]) : null);
			dto.setNombrePaquete(persona[11] != null ? String.valueOf(persona[11]) : null);
			return dto;
		}
		return null;
	}

}
