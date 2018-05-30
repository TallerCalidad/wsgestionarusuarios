package  com.uniajc.dao.api;

import javax.validation.Valid;

import com.uniajc.commons.ApiResponse;
import  com.uniajc.model.ApplicationObj;

import io.spring.guides.gs_producing_web_service.Respuesta;


public interface ApplicationDaoAPI {
	Respuesta save(@Valid ApplicationObj application);
	
	Respuesta edit(ApplicationObj application);
	
	Respuesta delete(Integer id);
	
	Respuesta getById(Integer id);
	
	ApiResponse getAll();
}
