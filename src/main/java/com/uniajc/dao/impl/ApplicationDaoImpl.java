package  com.uniajc.dao.impl;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.uniajc.commons.ApiResponse;
import  com.uniajc.dao.api.ApplicationDaoAPI;
import  com.uniajc.dao.mapper.ApplicationRowMapper;

import  com.uniajc.model.ApplicationObj;

import io.spring.guides.gs_producing_web_service.Respuesta;

@Scope("singleton")
@Repository("ApplicationDao")
public class ApplicationDaoImpl  extends JdbcDaoSupport implements ApplicationDaoAPI{
 
	private static Logger logger = LogManager.getLogger(ApplicationDaoImpl.class);
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	ApiResponse response;
	
	Respuesta respuesta;
	
	@Autowired
	private Environment env;
	
	@Qualifier("datasource2")
    @Autowired 
    DataSource dataSource;
 
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
	
	public Respuesta save(@Valid ApplicationObj application) {
		// TODO Auto-generated method stub
		
    		StringBuilder sql = new StringBuilder(100);
    		sql.append(env.getProperty("sql.insert"));
    		
    		MapSqlParameterSource params = new MapSqlParameterSource();
    		params.addValue("nombre", application.getNombre());
    		params.addValue("password", application.getPassword());
    		params.addValue("fase_estado", application.getFase_estado());
    		params.addValue("estado", application.getEstado());
    		params.addValue("notas", application.getNotas());
    		params.addValue("version", application.getVersion());

    		namedParameterJdbcTemplate.update(sql.toString(), params);
        
    		respuesta.setCodigo(1);
    		respuesta.setDescripcion("Exitoso");
    		
    		return respuesta;
		
	}

	public Respuesta edit(ApplicationObj application) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder(100);
		sql.append(env.getProperty("sql.update"));

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("id_app", application.getId_app());
		params.addValue("nombre", application.getNombre());
		params.addValue("password", application.getPassword());
		params.addValue("fase_estado", application.getFase_estado());
		params.addValue("estado", application.getEstado());
		params.addValue("notas", application.getNotas());
		params.addValue("version", application.getVersion());

		namedParameterJdbcTemplate.update(sql.toString(), params);
		respuesta.setCodigo(1);
		respuesta.setDescripcion("Exitoso");
		
		
		return respuesta;
	}

	public Respuesta delete(Integer id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder(100);
		sql.append(env.getProperty("sql.delete"));

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_app", id);

		namedParameterJdbcTemplate.update(sql.toString(), params);
		respuesta.setCodigo(1);
		respuesta.setDescripcion("Exitoso");
		
		return respuesta;
	}

	public Respuesta getById(Integer id_app) {
		
		// TODO Auto-generated method stub
	StringBuilder sql = new StringBuilder(100);
		sql.append(env.getProperty("sql.findById"));

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_app", id_app);

		//return namedParameterJdbcTemplate.queryForObject(sql.toString(), params, new ApplicationRowMapper());
		
		respuesta.setCodigo(1);
		respuesta.setDescripcion("Exitoso");
		//respuesta.setRespuesta(generateJson.respondeOBJSON(namedParameterJdbcTemplate.queryForObject(sql.toString(), params, new ApplicationRowMapper())));
		
		return respuesta;
	}

	public ApiResponse getAll() {
		
		//logger.info("Starting Spring Boot application..");
		response= new ApiResponse();
		List<ApplicationObj> list;
		StringBuilder sql = new StringBuilder(100);
		sql.append(env.getProperty("sql.select"));
		
		if(sql.length()>0) {
			try {
				list= namedParameterJdbcTemplate.query(sql.toString(), new ApplicationRowMapper());
				if(list.size()>0) {
					response= new ApiResponse(1,env.getProperty("msg.exitoso"),list);
				}else {
					response= new ApiResponse(1,env.getProperty("msg.noitems"),list);
				}
			} catch (DataAccessException e) {
				response= new ApiResponse(2,env.getProperty("msg.error")+" "+e.hashCode());
				//logger.error(e);
				logger.error(e.hashCode(), e); 
			}
		}else {
			response= new ApiResponse(2,env.getProperty("msg.error"));
			logger.info("La propiedad no tiene datos");
		}
		return response;
	}
	
}
