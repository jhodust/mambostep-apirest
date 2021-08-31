package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dao.IPaqueteDao;
import com.academia.mambostepapirest.dto.PaqueteDto;
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

}
