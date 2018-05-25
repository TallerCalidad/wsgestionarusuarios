package com.uniajc.facade.api;

import co.edu.uniajc.users.web_service.Respuesta;
import co.edu.uniajc.users.web_service.Usuario;

public interface UserFacadeApi {
	
	Respuesta createUser(Usuario user);
	
	Respuesta deleteUser(String identificacion);
	
	Respuesta getAllUser();
	
	Respuesta getUser(String identificacion);
}
