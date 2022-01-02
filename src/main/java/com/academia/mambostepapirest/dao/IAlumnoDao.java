package com.academia.mambostepapirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.mambostepapirest.entity.Alumno;

public interface IAlumnoDao extends JpaRepository<Alumno, Long>{

}
