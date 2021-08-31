package com.academia.mambostepapirest.dao;

import com.academia.mambostepapirest.entity.Clase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IClaseDao extends JpaRepository<Clase, Long>{

	@Query(value="select c.* from clases c where c.status", nativeQuery = true)
	public List<Clase> listarClasesActivas();
}
