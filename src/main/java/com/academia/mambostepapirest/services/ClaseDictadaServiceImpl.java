package com.academia.mambostepapirest.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dao.IClaseDao;
import com.academia.mambostepapirest.dao.IClaseDictadaDao;
import com.academia.mambostepapirest.entity.Clase;
import com.academia.mambostepapirest.entity.ClaseDictada;

@Service
public class ClaseDictadaServiceImpl implements IClaseDictadaService{

	Logger logger = LoggerFactory.getLogger(ClaseDictadaServiceImpl.class);

	
	@Autowired
	private IClaseDao claseDao;
	
	@Autowired
	private IClaseDictadaDao claseDictadaDao;
	
	@Override
	public void insertClaseADictar(String dia, String horaInicio) {
		// TODO Auto-generated method stub
		List<Clase> clases=claseDao.findClaseByDiaAndHoraInicio(dia, horaInicio);
		for(Clase clase:clases) {
			System.out.println("entra a recorrer el for de insertar clase a dictar");
			ClaseDictada claseADictar= new ClaseDictada();
			/*claseADictar.setIdClase(clase.getId());
			claseADictar.setFecha(LocalDate.now());
			claseADictar.setHora(horaInicio);
			claseADictar.setClase(clase.getNombre());
			claseADictar.setIdSede(clase.getSede().getId());
			claseADictar.setImpartida(Boolean.TRUE);*/
			claseADictar.setIdClase(14L);
			claseADictar.setFecha(LocalDate.now());
			claseADictar.setHora("15:00");
			claseADictar.setClase("pasito a pasito");
			claseADictar.setImpartida(Boolean.TRUE);
			claseADictar.setClaseActiva(Boolean.TRUE);
			claseADictar.setIdSede(1L);
			try {
				//claseDictadaDao.resetStatusActiveClasesDictada();
				claseDictadaDao.save(claseADictar);
			}catch(Exception e) {
				logger.info("**task scheduled insert clase a dictar**");
				logger.info(e.getMessage());
			}
		}
		
		
	}

	@Override
	public ClaseDictada findClaseActiva(Long idSede) {
		// TODO Auto-generated method stub
		return claseDictadaDao.findClaseDictadaByActivaAndSede(idSede);
	}

}
