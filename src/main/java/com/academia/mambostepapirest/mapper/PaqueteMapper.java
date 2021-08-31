package com.academia.mambostepapirest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.academia.mambostepapirest.dto.PaqueteDto;
import com.academia.mambostepapirest.entity.Paquete;

@Component
public class PaqueteMapper implements IPaqueteMapper {

	@Override
	public PaqueteDto convertPaqueteToPaqueteDto(Paquete paquete) {
		// TODO Auto-generated method stub
		PaqueteDto dto= new PaqueteDto();
		dto.setId(paquete.getId());
		dto.setNombre(paquete.getNombre());
		dto.setCantidadClasesSemana(paquete.getCantidadClasesSemana());
		dto.setPrecio(paquete.getPrecio());
		dto.setStatus(paquete.isStatus());
		return dto;
	}

	@Override
	public Paquete convertPaqueteDtoToPaquete(PaqueteDto paqueteDto) {
		// TODO Auto-generated method stub
		Paquete paquete= new Paquete();
		paquete.setId(paqueteDto.getId());
		paquete.setNombre(paqueteDto.getNombre());
		paquete.setCantidadClasesSemana(paqueteDto.getCantidadClasesSemana());
		paquete.setPrecio(paqueteDto.getPrecio());
		paquete.setStatus(paqueteDto.isStatus());
		return paquete;
	}

	@Override
	public List<PaqueteDto> convertListPaqueteToListPaqueteDto(List<Paquete> listPaquetes) {
		// TODO Auto-generated method stub
		List<PaqueteDto> listPaquetesDto=new ArrayList<PaqueteDto>();
		for(Paquete paquete: listPaquetes) {
			listPaquetesDto.add(this.convertPaqueteToPaqueteDto(paquete));
		}
		return listPaquetesDto;
	}

	@Override
	public List<Paquete> convertListPaqueteDtoToListPaquete(List<PaqueteDto> listPaquetesDto) {
		// TODO Auto-generated method stub
		List<Paquete> listPaquetes=new ArrayList<Paquete>();
		for(PaqueteDto paqueteDto: listPaquetesDto) {
			listPaquetes.add(this.convertPaqueteDtoToPaquete(paqueteDto));
		}
		return listPaquetes;
	}

}
