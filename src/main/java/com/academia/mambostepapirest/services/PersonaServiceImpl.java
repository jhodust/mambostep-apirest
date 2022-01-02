package com.academia.mambostepapirest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.academia.mambostepapirest.dao.IHorarioClaseCustomDao;
import com.academia.mambostepapirest.dao.IPersonaCustomDao;
import com.academia.mambostepapirest.dao.IPersonaDao;
import com.academia.mambostepapirest.mapper.IPersonaMapper;
import com.academia.mambostepapirest.utils.ApiResponseDto;
import com.academia.mambostepapirest.utils.MessagesError;
import com.academia.mambostepapirest.utils.MessagesSuccess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academia.mambostepapirest.dto.ControlAccesoDto;
import com.academia.mambostepapirest.dto.PersonaDto;
import com.academia.mambostepapirest.entity.Persona;
import com.academia.mambostepapirest.entity.Rol;
import com.academia.mambostepapirest.error.CustomException;

@Service
public class PersonaServiceImpl implements IPersonaService, UserDetailsService {

	
	private Logger logger= LoggerFactory.getLogger(PersonaServiceImpl.class);
	
	@Autowired
	private IPersonaDao personaDao;
	
	
	@Autowired
	private IPersonaCustomDao personaCustomDao;
	
	@Autowired
	private IPersonaMapper personaMapper;
	
	@Autowired
	private IHorarioClaseCustomDao horarioClaseCustomDao;
	
	
	@Override
	public List<PersonaDto> listPersonas(Long idSede) {
		// TODO Auto-generated method stub
		return personaCustomDao.listPersonas(idSede);
	}

	


	@Override
	public PersonaDto searchPersonaDto(String documento) {
		// TODO Auto-generated method stub
		PersonaDto personaSearched=personaCustomDao.consultarDatosBasicosPersona(documento); 
		if(personaSearched==null) {
			throw new CustomException(MessagesError.PERSONA_NO_ENCONTRADA_POR_DOCUMENTO);
		}
		return personaSearched;
	}
	
	public Persona searchPersona(String documento) {
		// TODO Auto-generated method stub
		return personaDao.findByIdentificacion(documento);
	}


	@Override
	public PersonaDto updatePersona(Long idPersona, PersonaDto personaDto) {
		// TODO Auto-generated method stub
		
		Persona persona=this.personaMapper.convertPersonaDtoToPersona(personaDto);
		personaDao.save(persona);
		return personaDto;
	}


	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Persona persona=personaDao.findByUsername(username);
		
		if(persona == null) {
			logger.error("No existe el usuario " + username + " en el sistema");
			throw new UsernameNotFoundException("No existe el usuario " + username + " en el sistema");
		}
		
		List<GrantedAuthority> authorities=persona.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getAuthority()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		return new User(persona.getUsername(), persona.getPassword(), persona.isEnabled(), true, true, true, authorities);
		
	}



	@Transactional(readOnly = true)
	@Override
	public PersonaDto searchPersonaByUsername(String username) {
		// TODO Auto-generated method stub
		System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
		System.out.println(username);
		return personaMapper.convertPersonaToPersonaDto(this.personaDao.findByUsername(username));
	}



	@Override
	public ControlAccesoDto searchAlumnoControlAcceso(String identificacion) {
		// TODO Auto-generated method stub
		
		ControlAccesoDto dto = personaCustomDao.consultarControlAccesoAlumno(identificacion);
		if(dto != null) {
			dto.setHorario(horarioClaseCustomDao.searchHorarioAlumno(identificacion));
		}
		return dto;
	}



	@Override
	public Persona findPersonaById(Long id) {
		// TODO Auto-generated method stub
		return personaDao.findById(id).orElseThrow(() -> new CustomException(MessagesError.PERSONA_NO_ENCONTRADA_POR_ID));
	}



	@Override
	public ResponseEntity<?> searchPersonaById(Long idPersona) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(ApiResponseDto.ok(personaMapper.convertPersonaToPersonaDto(this.findPersonaById(idPersona))));
	}

}
