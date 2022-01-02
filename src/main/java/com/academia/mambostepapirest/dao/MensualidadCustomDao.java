package com.academia.mambostepapirest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.academia.mambostepapirest.dto.MensualidadDto;
import com.academia.mambostepapirest.entity.Mensualidad;
import com.academia.mambostepapirest.mapper.IMensualidadMapper;

@Repository
public class MensualidadCustomDao implements IMensualidadCustomDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IMensualidadMapper mensualidadMapper;
	
	@Override
	public void insertMensualidad(MensualidadDto mensualidadDto) {
		// TODO Auto-generated method stub
		
		StringBuilder query = new StringBuilder()
				.append("insert into mensualidades")
				.append(" (fecha_inicio, fecha_fin, nombre_paquete, observaciones, precio_paquete, precio_pactado, id_persona, has_clases_ilimitadas)  ")
				.append(" VALUES (?,?,?,?,?,?,?,?)");
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
				// Calendar utc = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
				System.out.println("sdgggggggggggggggg");
				System.out.println(mensualidadDto.getFechaInicio());
				
				ps.setObject(1, mensualidadDto.getFechaInicio());
				ps.setObject(2, mensualidadDto.getFechaFin() );
				ps.setString(3, mensualidadDto.getNombrePaquete());
				ps.setString(4, mensualidadDto.getObservaciones());
				ps.setString(5, mensualidadDto.getPrecioPaquete());
				ps.setString(6, mensualidadDto.getPrecioPactado());
				ps.setLong(7, mensualidadDto.getIdPersona());
				ps.setBoolean(8, mensualidadDto.isHasClasesIlimitadas());
				return ps;
			}

		}, keyHolder);

		mensualidadDto.setId((Long) keyHolder.getKeys().get("id"));
	}
	
	@Override
	public List<MensualidadDto> consultarHistoricoMensualidades(String documento) {
		// TODO Auto-generated method stub
		
		StringBuilder query = new StringBuilder()
				.append("select men.id as id_mensualidad, men.fecha_inicio, men.fecha_fin, ")
				.append("  men.nombre_paquete, men.precio_paquete, men.precio_pactado, COALESCE(men.observaciones,'') as observaciones,")
				.append(" STRING_AGG(cla.nombre,',') as clases, men.has_clases_ilimitadas,  ")
				.append(" per.id as id_persona")
				.append(" from mensualidades men")
				.append(" join personas per on men.id_persona=per.id")
				.append(" join mensualidad_clases mc on men.id=mc.id_mensualidad")
				.append(" join clases cla on cla.id=mc.id_clase")
				.append(" where per.identificacion=?1")
				.append(" group by men.id, per.id")
				.append(" order by fecha_inicio desc");
		Query q= entityManager.createNativeQuery(query.toString());
		q.setParameter(1, documento);
		
		List<Object[]> result=q.getResultList();
		if(result.size()>0) {
			return mensualidadMapper.convertListObjectToListMensualidadDto(result);
		}
		return null;
	}

}
