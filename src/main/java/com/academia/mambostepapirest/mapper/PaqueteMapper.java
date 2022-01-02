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
		dto.setCantidadClasesEstandarSemana(paquete.getCantidadClasesEstandarSemana());
		dto.setPrecio(paquete.getPrecio());
		dto.setStatus(paquete.isStatus());
		dto.setVentaPublico(paquete.isVentaPublico());
		dto.setHasClasesCrewLatina(paquete.isHasClasesCrewLatina());
		dto.setHasClasesCrewUrbano(paquete.isHasClasesCrewUrbano());
		dto.setHasClasesIlimitadas(paquete.isHasClasesIlimitadas());
		dto.setDiasDuracion(paquete.getDiasDuracion());
		return dto;
	}

	@Override
	public Paquete convertPaqueteDtoToPaquete(PaqueteDto paqueteDto) {
		// TODO Auto-generated method stub
		Paquete paquete= new Paquete();
		paquete.setId(paqueteDto.getId());
		paquete.setNombre(paqueteDto.getNombre());
		paquete.setCantidadClasesEstandarSemana(paqueteDto.getCantidadClasesEstandarSemana());
		paquete.setPrecio(paqueteDto.getPrecio());
		paquete.setStatus(paqueteDto.isStatus());
		paquete.setVentaPublico(paqueteDto.isVentaPublico());
		paquete.setHasClasesCrewLatina(paqueteDto.isHasClasesCrewLatina());
		paquete.setHasClasesCrewUrbano(paqueteDto.isHasClasesCrewUrbano());
		paquete.setHasClasesIlimitadas(paqueteDto.isHasClasesIlimitadas());
		paquete.setDiasDuracion(paqueteDto.getDiasDuracion());
		System.out.println("converttttttttttttttttt");
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
