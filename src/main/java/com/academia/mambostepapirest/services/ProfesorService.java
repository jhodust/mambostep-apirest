package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dao.IProfesorCustomDao;
import com.academia.mambostepapirest.dao.IProfesorDao;
import com.academia.mambostepapirest.dto.ProfesorDto;
import com.academia.mambostepapirest.entity.Profesor;
import com.academia.mambostepapirest.entity.TipoPersonas;
import com.academia.mambostepapirest.error.CustomException;
import com.academia.mambostepapirest.mapper.IProfesorMapper;
import com.academia.mambostepapirest.utils.ApiResponseDto;
import com.academia.mambostepapirest.utils.MessagesError;
import com.academia.mambostepapirest.utils.MessagesSuccess;

@Service
public class ProfesorService implements IProfesorService{

	@Autowired
	private IProfesorMapper profesorMapper;
	
	@Autowired
	private IProfesorCustomDao profesorCustomDao;
	
	@Autowired
	private IProfesorDao profesorDao;
	
	@Autowired
	private ITipoPersonaService tipoPersonaService;
	
	@Autowired
	private ISedeService sedeService;
	
	@Override
	public ResponseEntity<?> saveProfesor(ProfesorDto profesorDto) {
		// TODO Auto-generated method st ub
		/*System.out.println("profesorId: " + profesorDto.getId());
		//System.out.println("profesorId: " + profesorDto.getValorClase());
		//System.out.println("profesorId: " + profesorDto.getPagoClasesMes());
		//profesorCustomDao.insertProfesor(profesorDto.getId(), profesorDto.getValorClase(), profesorDto.getPagoClasesMes());
		*/
		profesorDao.save(profesorMapper.convertProfesorDtoToProfesor(profesorDto, tipoPersonaService.findTipoPersonaByTipo(TipoPersonas.PROFESOR.toString()), sedeService.findSedeById(profesorDto.getIdSede())));
		return ResponseEntity.ok(ApiResponseDto.ok(MessagesSuccess.REGISTRO_PROFESOR));
	}

	@Override
	public ResponseEntity<?> listProfesores() {
		// TODO Auto-generated method stub
		List<Profesor> listProfesores=profesorDao.findAll();
		return ResponseEntity.ok(ApiResponseDto.ok(profesorMapper.convertListProfesorToListProfesoresDto(listProfesores)));
	}

	@Override
	public Profesor findProfesorById(Long idProfesor) {
		// TODO Auto-generated method stub
		return profesorDao.findById(idProfesor).orElseThrow(() -> new CustomException(MessagesError.PROFESOR_NO_ENCONTRADO_POR_ID));
	}

	@Override
	public ResponseEntity<?> searchProfesorById(Long idProfesor) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(ApiResponseDto.ok(profesorMapper.convertProfesorToProfesorDto(this.findProfesorById(idProfesor))));
	}

}
