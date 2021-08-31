package com.academia.mambostepapirest.dao;

import com.academia.mambostepapirest.dto.HorarioClaseDto;

import java.util.List;

public interface IHorarioClaseCustomDao {

	public List<HorarioClaseDto> searchHorarioAlumno(String identificacion);
}
