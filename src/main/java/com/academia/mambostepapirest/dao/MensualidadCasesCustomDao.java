package com.academia.mambostepapirest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public class MensualidadCasesCustomDao implements IMensualidadClasesCustomDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Modifying
	@Override
	public void insertMensualidadClases(Long idMensualidad, List<Long> idsClases) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("insert into mensualidad_clases (id_mensualidad, id_clase) values ");
		
		int i =1;
		for(Long idClase: idsClases) {
			sb.append("("+idMensualidad+","+ idClase+")");
			if(i!=idsClases.size()) {
				sb.append(",");
			}
			i++;
		}
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(sb.toString());
		Query q= entityManager.createNativeQuery(sb.toString());
		q.executeUpdate();
	}

}
