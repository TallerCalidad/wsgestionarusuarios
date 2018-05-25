package com.uniajc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.uniajc.dao.api.UserDaoApi;
import com.uniajc.dao.mapper.UserRowMapper;
import com.uniajc.error.ServiceExceptionApp;
import co.edu.uniajc.users.web_service.Usuario;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Scope("singleton")
@Repository("UserDao")
public class UserDaoImpl extends JdbcDaoSupport implements UserDaoApi {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	private Environment env;

	@PostConstruct
	private void initalize() {
		setDataSource(dataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public void createUser(Usuario usuario) throws ServiceExceptionApp {

		try {
			StringBuilder sql = new StringBuilder(100);
			sql.append(env.getProperty("sql.insert"));

			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("identificacion", usuario.getIdentificacion());
			params.addValue("nombre", usuario.getNombre());
			params.addValue("direccion", usuario.getDireccion());
			params.addValue("telefono", usuario.getTelefono());
			params.addValue("correo", usuario.getCorreo());
			params.addValue("edad", usuario.getEdad());

			namedParameterJdbcTemplate.update(sql.toString(), params);
		} catch (BadSqlGrammarException e) {
			throw new ServiceExceptionApp(e.toString(), e);
		} catch (DataAccessException e) {
			throw new ServiceExceptionApp(e.toString(), e);
		} catch (Throwable t) {
			throw new ServiceExceptionApp(t.toString(), t);
		}
	}

	

	@Override
	public void deleteUser(String identificacion) throws ServiceExceptionApp {


		try {
			StringBuilder sql = new StringBuilder(100);
			sql.append(env.getProperty("sql.delete"));

			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("identificacion", identificacion);

			namedParameterJdbcTemplate.update(sql.toString(), params);

		} catch (BadSqlGrammarException e) {
			throw new ServiceExceptionApp(e.getMessage(), e);
		} catch (DataAccessException e) {
			throw new ServiceExceptionApp(e.getMessage(), e);
		} catch (Throwable t) {
			throw new ServiceExceptionApp(t.getMessage(), t);
		}

	}

	@Override
	public Usuario getUser(String identificacion) throws ServiceExceptionApp {

		
		try {
			StringBuilder sql = new StringBuilder(100);
			sql.append(env.getProperty("sql.findById"));
			
			MapSqlParameterSource params= new MapSqlParameterSource();
			params.addValue("identificacion", identificacion);
			
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), params, new UserRowMapper());
			
		} catch (BadSqlGrammarException e) {

			throw new ServiceExceptionApp(e.getMessage());
		}catch (EmptyResultDataAccessException e) {

			throw new ServiceExceptionApp(env.getProperty("msg.noitems"),e);
		}catch (Throwable t){
			throw new ServiceExceptionApp(t.getMessage(), t);
		}
	}

	@Override
	public List<Usuario> getAllUser() throws ServiceExceptionApp {

		try {
			StringBuilder sql = new StringBuilder(100);
			sql.append(env.getProperty("sql.select"));
			
			return namedParameterJdbcTemplate.query(sql.toString(), new UserRowMapper());
			
		} catch (BadSqlGrammarException e) {

			throw new ServiceExceptionApp(e.getMessage(),e);
		}catch (EmptyResultDataAccessException e) {

			throw new ServiceExceptionApp(e.getMessage(),e);
		}catch (Throwable e) {

			throw new ServiceExceptionApp(e.getMessage(), e);
		}
	}

}
