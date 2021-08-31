package com.academia.mambostepapirest.services;

import java.util.List;

import com.academia.mambostepapirest.dao.IPersonaCustomDao;
import com.academia.mambostepapirest.dao.IPersonaDao;
import com.academia.mambostepapirest.mapper.IPersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dto.PersonaDto;
import com.academia.mambostepapirest.entity.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;
	
	@Autowired
	private IPersonaCustomDao personaCustomDao;
	
	@Autowired
	private IPersonaMapper personaMapper;
	
	
	@Override
	public List<PersonaDto> listPersonas(Long idSede) {
		// TODO Auto-generated method stub
		return personaCustomDao.listPersonas(idSede);
	}

	

	@Override
	public PersonaDto savePersona(PersonaDto dto) {
		// TODO Auto-generated method stub
		System.out.println("PPPPPPPPPPPPPP ID: " + dto.getId());
		Persona p= personaMapper.convertPersonaDtoToPersona(dto);
		personaDao.save(p);
		System.out.println("PPPPPPPPPPPPPP ID: " + p.getId());
		return personaMapper.convertPersonaToPersonaDto(p);
	}

	@Override
	public PersonaDto searchPersona(String documento) {
		// TODO Auto-generated method stub
		return personaCustomDao.consultarDatosBasicosPersona(documento);
	}



	@Override
	public PersonaDto updatePersona(Long idPersona, PersonaDto personaDto) {
		// TODO Auto-generated method stub
		
		Persona persona=this.personaMapper.convertPersonaDtoToPersona(personaDto);
		personaDao.save(persona);
		return personaDto;
	}

}
