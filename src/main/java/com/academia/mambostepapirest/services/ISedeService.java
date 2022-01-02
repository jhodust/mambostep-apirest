package com.academia.mambostepapirest.services;

import com.academia.mambostepapirest.dto.SedeDto;
import java.util.List;

import com.academia.mambostepapirest.entity.Sede;

public interface ISedeService {

	public Sede findSedeById(Long idSede);
	public List<SedeDto> findAllSedes();
}
