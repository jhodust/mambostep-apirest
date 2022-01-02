package com.academia.mambostepapirest.dao;

import com.academia.mambostepapirest.entity.Asistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.mambostepapirest.entity.Clase;

public interface IAsistenciaDao extends JpaRepository<Asistencia, Long>{

}
