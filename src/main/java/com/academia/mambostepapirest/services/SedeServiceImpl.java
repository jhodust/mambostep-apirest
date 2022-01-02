package com.academia.mambostepapirest.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.academia.mambostepapirest.dao.ISedeDao;
import com.academia.mambostepapirest.dto.SedeDto;

import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.entity.Sede;
import com.academia.mambostepapirest.error.CustomException;
import com.academia.mambostepapirest.mapper.ISedeMapper;
import com.academia.mambostepapirest.utils.MessagesError;

@Service
public class SedeServiceImpl implements ISedeService {

	@Autowired
	private ISedeDao sedeDao;
	
	@Autowired
	private ISedeMapper sedeMapper;
	
	@Override
	public Sede findSedeById(Long idSede) {
		// TODO Auto-generated method stub
		return sedeDao.findById(idSede).orElseThrow(() -> new CustomException(MessagesError.SEDE_NO_ENCONTRADA_POR_ID ));
	}

	@Override
	public List<SedeDto> findAllSedes() {
		// TODO Auto-generated method stub
		return sedeMapper.convertListSedeToListSedeDto(sedeDao.findAll());
	}

}
