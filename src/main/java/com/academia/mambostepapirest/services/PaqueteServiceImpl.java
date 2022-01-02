package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dao.IPaqueteDao;
import com.academia.mambostepapirest.dto.PaqueteDto;
import com.academia.mambostepapirest.entity.Paquete;
import com.academia.mambostepapirest.error.CustomException;
import com.academia.mambostepapirest.mapper.IPaqueteMapper;
import com.academia.mambostepapirest.utils.ApiResponseDto;
import com.academia.mambostepapirest.utils.MessagesError;
import com.academia.mambostepapirest.utils.MessagesSuccess;

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
	public ResponseEntity<?> savePaquete(PaqueteDto paqueteDto) {
		// TODO Auto-generated method stub
		Paquete paquete=paqueteMapper.convertPaqueteDtoToPaquete(paqueteDto);
		paqueteDao.save(paquete);
		return ResponseEntity.ok(ApiResponseDto.ok(MessagesSuccess.REGISTRO_PAQUETE));
	}

	@Override
	public Paquete findPaqueteById(Long idPaquete) {
		// TODO Auto-generated method stub
		return paqueteDao.findById(idPaquete).orElseThrow(() -> new CustomException(MessagesError.PAQUETE_NO_ENCONTRADO_POR_ID ));
	}

}
