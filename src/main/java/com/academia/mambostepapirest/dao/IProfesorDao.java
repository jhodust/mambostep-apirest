package com.academia.mambostepapirest.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academia.mambostepapirest.entity.Profesor;
import com.academia.mambostepapirest.entity.Sede;

public interface IProfesorDao extends JpaRepository<Profesor, Long>{

	@Query(value="select p from Profesor p where p.id = :id")
	public Profesor findProfesorById(@Param("id") Long idProfesor);
	
}
