package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.academia.mambostepapirest.dao.IClaseDao;
import com.academia.mambostepapirest.mapper.IClaseMapper;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dto.ClaseDto;

@Service
public class ClaseServiceImpl implements IClaseService {

	@Autowired
	private IClaseDao claseDao;
	
	@Autowired
	private IClaseMapper claseMapper;
	
	@Override
	public List<ClaseDto> listarClases() {
		// TODO Auto-generated method stub
		return claseMapper.convertListClaseToListClaseDto(claseDao.listarClasesActivas());
	}

}
