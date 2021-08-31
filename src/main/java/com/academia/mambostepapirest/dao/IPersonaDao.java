package com.academia.mambostepapirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.mambostepapirest.entity.Persona;

public interface IPersonaDao extends JpaRepository<Persona, Long> {

}
