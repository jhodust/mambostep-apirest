package com.academia.mambostepapirest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public class AlumnoCustomDao implements IAlumnoCustomDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Modifying
	@Override
	public void insertAlumno(Long idPersona) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("insert into alumnos (id_persona) values (?);");
		
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(sb.toString());
		Query q= entityManager.createNativeQuery(sb.toString());
		q.setParameter(1, idPersona);
		q.executeUpdate();
	}

}
