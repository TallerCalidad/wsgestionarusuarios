package  com.uniajc.service.api;

import java.util.List;

import javax.validation.Valid;

import  com.uniajc.model.ApplicationObj;

import io.spring.guides.gs_producing_web_service.Respuesta;

public interface ApplicationServiceAPI {
	
	Respuesta save(@Valid ApplicationObj application);
	
	Respuesta edit(ApplicationObj application);
	
	Respuesta delete(Integer id);
	
	Respuesta getById(Integer id);
	
	Respuesta getAll();
}
