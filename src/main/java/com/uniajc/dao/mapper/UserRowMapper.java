package com.uniajc.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.edu.uniajc.users.web_service.Usuario;


public class UserRowMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rn) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setIdentificacion(rs.getString("identificacion"));
		usuario.setCorreo(rs.getString("correo"));
		usuario.setDireccion(rs.getString("direccion"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setTelefono(rs.getString("telefono"));
		usuario.setEdad(rs.getInt("edad"));
		return usuario;
	}

}
