package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.academia.mambostepapirest.dao.IClaseDao;
import com.academia.mambostepapirest.dao.IProfesorDao;
import com.academia.mambostepapirest.mapper.IClaseMapper;
import com.academia.mambostepapirest.utils.ApiResponseDto;
import com.academia.mambostepapirest.utils.MessagesError;
import com.academia.mambostepapirest.utils.MessagesSuccess;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academia.mambostepapirest.dto.ClaseDto;
import com.academia.mambostepapirest.dto.HorarioClaseDto;
import com.academia.mambostepapirest.entity.Clase;
import com.academia.mambostepapirest.error.CustomException;

@Service
public class ClaseServiceImpl implements IClaseService {

	@Autowired
	private IClaseDao claseDao;
	
	@Autowired
	private IProfesorService profesorService;
	
	@Autowired
	private ISedeService sedeService;
	
	@Autowired
	private IClaseMapper claseMapper;
	
	@Autowired
	private IHorarioClaseService horarioClaseService;
	
	
	@Override
	public List<ClaseDto> listAllClases() {
		// TODO Auto-generated method stub
		return claseMapper.convertListClaseToListClaseDto(claseDao.findAll());
	}
	
	@Override
	public List<ClaseDto> listarClasesActivas() {
		// TODO Auto-generated method stub
		return claseMapper.convertListClaseToListClaseDto(claseDao.listarClasesActivas());
	}

	//@Transactional(rollbackFor=Exception.class )
	@Override
	public ResponseEntity<?> saveClase(ClaseDto dto) {
		// TODO Auto-generated method stub
		System.out.println("entra a guardar");
		if(claseDao.validateDuplicateNameClase(dto.getNombre(), dto.getIdSede(), dto.getId())) {
			System.out.println("pasa validacion del if");
			Clase clase= this.insertClase(dto);
			System.out.println("guarda clase");
			this.insertHorarioClase(dto.getListHorarioClase(), clase);
			System.out.println("inserta horario");
		}
		System.out.println("retorna");
		return ResponseEntity.ok(ApiResponseDto.ok(MessagesSuccess.REGISTRO_CLASE));
	}
	
	public Clase insertClase(ClaseDto dto) {
		Clase clase=claseMapper.convertClaseDtoToClase(dto,
				profesorService.findProfesorById(dto.getIdProfesor()),
						sedeService.findSedeById(dto.getIdSede()));
		claseDao.save(clase);
		return clase;
	}
	
	/*public void deleteHorarioClase(Long idClase) {
		horarioClaseService.deleteHorarioClase(idClase);
	}*/
	
	public void insertHorarioClase(List<HorarioClaseDto> listHorarioClaseDto, Clase clase) {
		horarioClaseService.saveHorarioClase(listHorarioClaseDto, clase);
	}

	@Override
	public ClaseDto findClaseById(Long idClase) {
		// TODO Auto-generated method stub
		return claseMapper.convertClaseToClaseDto(claseDao.findById(idClase).orElseThrow(() -> new CustomException(MessagesError.CLASE_NO_ENCONTRADA_POR_ID )));
	}

}
