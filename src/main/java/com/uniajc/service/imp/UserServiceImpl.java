package com.uniajc.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.uniajc.commons.GenerateJson;
import com.uniajc.dao.api.UserDaoApi;
import com.uniajc.error.ServiceExceptionApp;
import com.uniajc.service.api.UserServiceApi;
import co.edu.uniajc.users.web_service.Respuesta;
import co.edu.uniajc.users.web_service.Usuario;

@Scope("singleton")
@Service("UserService")
public class UserServiceImpl implements UserServiceApi{

	private GenerateJson generateJson = new GenerateJson();
	
	Respuesta respuesta;
	
	@Autowired
	Environment env;
	
	@Autowired
	UserDaoApi userDao;
	
	@Override
	public Respuesta createUser(Usuario user) {
		respuesta = new Respuesta();
		try {
			userDao.createUser(user);
			respuesta.setCodigo(200);
			respuesta.setRespuesta(env.getProperty("msg.create"));
		} catch (ServiceExceptionApp e) {
			respuesta.setCodigo(e.getCause().hashCode());
			respuesta.setRespuesta(e.getMessage());
		}
		
		return respuesta;
	}

	

	@Override
	public Respuesta deleteUser(String identificacion) {
		respuesta = new Respuesta();
		try {
			userDao.deleteUser(identificacion);
			respuesta.setCodigo(200);
			respuesta.setRespuesta(env.getProperty("msg.delete"));
		} catch (ServiceExceptionApp e) {
			respuesta.setCodigo(e.getCause().hashCode());
			respuesta.setRespuesta(e.getMessage());
		}
		
		return respuesta;
	}

	@Override
	public Respuesta getAllUser() {
		respuesta = new Respuesta();
		try {
			respuesta.setCodigo(200);
			respuesta.setRespuesta(generateJson.respondeOBJSON(userDao.getAllUser()));
		} catch (ServiceExceptionApp e) {
			respuesta.setCodigo(e.getCause().hashCode());
			respuesta.setRespuesta(e.getMessage());
		}
		return respuesta;
	}

	@Override
	public Respuesta getUser(String identificacion) {
		respuesta = new Respuesta();
		try {
			respuesta.setCodigo(200);
			respuesta.setRespuesta(generateJson.respondeOBJSON(userDao.getUser(identificacion)));
		} catch (ServiceExceptionApp e) {
			respuesta.setCodigo(e.getCause().hashCode());
			respuesta.setRespuesta(e.getMessage());
		}
		return respuesta;
	}
	
}
