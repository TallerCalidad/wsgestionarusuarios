package com.uniajc.facade.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniajc.facade.api.UserFacadeApi;
import com.uniajc.service.api.UserServiceApi;
import co.edu.uniajc.users.web_service.Respuesta;
import co.edu.uniajc.users.web_service.Usuario;

@Scope("singleton")
@Service("UserFacade")
@Transactional(rollbackFor = {Exception.class})
public class UserFacadeImpl implements UserFacadeApi {

	@Autowired
	UserServiceApi userServiceApi;
	
	@Override
	public Respuesta createUser(Usuario user) {
		return userServiceApi.createUser(user);
	}


	@Override
	public Respuesta deleteUser(String identificacion) {
		return userServiceApi.deleteUser(identificacion);
	}

	@Override
	public Respuesta getAllUser() {
		return userServiceApi.getAllUser();
	}

	@Override
	public Respuesta getUser(String identificacion) {
		return userServiceApi.getUser(identificacion);
	}

}
