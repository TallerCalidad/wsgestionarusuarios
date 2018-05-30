package  com.uniajc.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import  com.uniajc.model.ApplicationObj;


public class ApplicationRowMapper implements RowMapper<ApplicationObj> {

	public ApplicationObj mapRow(ResultSet rs, int rn) throws SQLException {
		ApplicationObj application = new ApplicationObj();
		application.setId_app(rs.getInt("id_app"));
		application.setNombre(rs.getString("nombre"));
		application.setEstado(rs.getString("estado"));
		application.setFase_estado(rs.getString("fase_estado"));
		application.setNotas(rs.getString("notas"));
		application.setPassword(rs.getString("password"));
		
		return application;
	}
	
}
