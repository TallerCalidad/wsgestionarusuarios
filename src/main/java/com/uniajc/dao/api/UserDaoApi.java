package com.uniajc.dao.api;

import java.util.List;

import com.uniajc.error.ServiceExceptionApp;

import co.edu.uniajc.users.web_service.Usuario;



public interface UserDaoApi {
	void createUser(Usuario usuario) throws ServiceExceptionApp;
	void deleteUser(String identificacion) throws ServiceExceptionApp;
	Usuario getUser(String identificacion) throws ServiceExceptionApp;
	List<Usuario> getAllUser() throws ServiceExceptionApp;
}
