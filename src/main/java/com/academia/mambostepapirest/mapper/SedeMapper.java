package com.academia.mambostepapirest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dto.SedeDto;
import com.academia.mambostepapirest.entity.Sede;

@Component
public class SedeMapper implements ISedeMapper{

	@Override
	public Sede convertSedeDtoToSede(SedeDto sedeDto) {
		// TODO Auto-generated method stub
		Sede sede = new Sede();
		sede.setId(sedeDto.getId());
		sede.setNombre(sedeDto.getNombre());
		sede.setDireccion(sede.getDireccion());
		return sede;
	}

	@Override
	public SedeDto convertSedeToSedeDto(Sede sede) {
		// TODO Auto-generated method stub
		SedeDto sedeDto = new SedeDto();
		sedeDto.setId(sede.getId());
		sedeDto.setNombre(sede.getNombre());
		sedeDto.setDireccion(sede.getDireccion());
		return sedeDto;
	}

	@Override
	public List<SedeDto> convertListSedeToListSedeDto(List<Sede> listSedes) {
		// TODO Auto-generated method stub
		List<SedeDto> listSedeDto = new ArrayList<>();
		for(Sede sede: listSedes) {
			listSedeDto.add(this.convertSedeToSedeDto(sede));
		}
		return listSedeDto;
	}

	
}
