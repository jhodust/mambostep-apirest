package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.academia.mambostepapirest.mapper.IAlumnoMapper;
import com.academia.mambostepapirest.utils.ApiResponseDto;
import com.academia.mambostepapirest.utils.MessagesError;
import com.academia.mambostepapirest.utils.MessagesSuccess;
import com.academia.mambostepapirest.dao.IAlumnoCustomDao;
import com.academia.mambostepapirest.dao.IAlumnoDao;
import com.academia.mambostepapirest.dto.AlumnoDto;
import com.academia.mambostepapirest.entity.Alumno;
import com.academia.mambostepapirest.entity.Profesor;
import com.academia.mambostepapirest.entity.TipoPersonas;
import com.academia.mambostepapirest.error.CustomException;

@Service
public class AlumnoService implements IAlumnoService {

	@Autowired
	private IAlumnoMapper alumnoMapper;
	
	@Autowired
	private IAlumnoCustomDao alumnoCustomDao;
	
	@Autowired
	private IAlumnoDao alumnoDao;
	
	@Autowired
	private ITipoPersonaService tipoPersonaService;
	
	@Autowired
	private ISedeService sedeService;
	
	@Override
	public ResponseEntity<?> saveAlumno(AlumnoDto alumnoDto) {
		// TODO Auto-generated method stub
		
		alumnoDao.save(alumnoMapper.convertAlumnoDtoToAlumno(alumnoDto, 
				tipoPersonaService.findTipoPersonaByTipo(TipoPersonas.PROFESOR.toString()), 
				sedeService.findSedeById(alumnoDto.getIdSede())));
		return ResponseEntity.ok(ApiResponseDto.ok(MessagesSuccess.REGISTRO_ALUMNO));
	}

	@Override
	public ResponseEntity<?> listAlumnos() {
		// TODO Auto-generated method stub
		List<Alumno> listAlumnos=alumnoDao.findAll();
		return ResponseEntity.ok(ApiResponseDto.ok(alumnoMapper.convertListAlumnosToListAlumnosDto(listAlumnos)));
	}

	@Override
	public Alumno findAlumnoById(Long idPersona) {
		// TODO Auto-generated method stub
		return alumnoDao.findById(idPersona).orElseThrow(() -> new CustomException(MessagesError.ALUMNO_NO_ENCONTRADO_POR_ID));
	}

	@Override
	public ResponseEntity<?> searchAlumnoById(Long idPersona) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(ApiResponseDto.ok(alumnoMapper.convertAlumnoToAlumnoDto(this.findAlumnoById(idPersona))));
	}
	
	

}
