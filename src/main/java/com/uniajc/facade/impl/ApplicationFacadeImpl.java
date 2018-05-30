package  com.uniajc.facade.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import  com.uniajc.facade.api.ApplicationFacadeAPI;
import  com.uniajc.model.ApplicationObj;
import  com.uniajc.service.api.ApplicationServiceAPI;

import io.spring.guides.gs_producing_web_service.Respuesta;

@Scope("singleton")
@Service
@Transactional(rollbackFor = {Exception.class})
public class ApplicationFacadeImpl implements ApplicationFacadeAPI{
	
	@Autowired
	ApplicationServiceAPI api;

	public Respuesta save(@Valid ApplicationObj application) {
		// TODO Auto-generated method stub
		return api.save(application);
	}

	public Respuesta edit(ApplicationObj application) {
		// TODO Auto-generated method stub
		return api.edit(application);
	}

	public Respuesta delete(Integer id) {
		// TODO Auto-generated method stub
		return api.delete(id);
	}

	public Respuesta getById(Integer id) {
		// TODO Auto-generated method stub
		return api.getById(id);
	}

	public Respuesta getAll() {
		// TODO Auto-generated method stub
		return api.getAll();
	}

}
