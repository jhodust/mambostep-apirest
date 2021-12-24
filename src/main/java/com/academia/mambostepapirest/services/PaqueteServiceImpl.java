package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dao.IPaqueteDao;
import com.academia.mambostepapirest.dto.PaqueteDto;
import com.academia.mambostepapirest.entity.Paquete;
import com.academia.mambostepapirest.mapper.IPaqueteMapper;

@Service
public class PaqueteServiceImpl implements IPaqueteService {

	@Autowired
	private IPaqueteDao paqueteDao;
	
	@Autowired
	private IPaqueteMapper paqueteMapper;
	
	@Override
	public List<PaqueteDto> listarPaquetes() {
		// TODO Auto-generated method stub
		return paqueteMapper.convertListPaqueteToListPaqueteDto(paqueteDao.findAll());
	}

	@Override
	public ResponseEntity<?> save(PaqueteDto dto) {
		// TODO Auto-generated method stub
		Paquete paquete=paqueteMapper.convertPaqueteDtoToPaquete(dto);
		System.out.println(paquete.getCantidadClasesEstandarSemana());
		System.out.println(paquete.getNombre());
		System.out.println(paquete.getPrecio());
		System.out.println(paquete.isHasClasesCrewLatina());
		System.out.println(paquete.isHasClasesCrewUrbano());
		System.out.println(paquete.isVentaPublico());
		System.out.println(paquete.isStatus());
		System.out.println(paquete.getId());
		return ResponseEntity.ok(paqueteDao.save(paquete));
	}

}
