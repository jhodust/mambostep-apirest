package com.academia.mambostepapirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dao.ITipoPersonaDao;
import com.academia.mambostepapirest.entity.TipoPersona;
import com.academia.mambostepapirest.entity.TipoPersonas;

@Service
public class TipoPersonaServiceImpl implements ITipoPersonaService {

	@Autowired
	private ITipoPersonaDao tipoPersonaDao;
	
	@Override
	public TipoPersona findTipoPersonaByTipo(String tipoPersona) {
		// TODO Auto-generated method stub
		return tipoPersonaDao.findTipoPersonaByTipo(tipoPersona);
	}

}
