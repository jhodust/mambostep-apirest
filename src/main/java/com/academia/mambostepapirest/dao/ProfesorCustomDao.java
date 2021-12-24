package com.academia.mambostepapirest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public class ProfesorCustomDao implements IProfesorCustomDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	@Transactional
	@Modifying
	@Override
	public void insertProfesor(Long idPersona, double valorClase, double pagoClasesMes) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("insert into profesores (id_persona, valor_clase, pago_clases_mes) values (?,?,?);");
		
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(sb.toString());
		Query q= entityManager.createNativeQuery(sb.toString());
		q.setParameter(1, idPersona)
		.setParameter(2, valorClase)
		.setParameter(3, pagoClasesMes);
		q.executeUpdate();
	}

}
