package  com.uniajc.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.uniajc.commons.ApiResponse;
import com.uniajc.commons.GenerateJson;
import  com.uniajc.dao.api.ApplicationDaoAPI;
import  com.uniajc.model.ApplicationObj;
import  com.uniajc.service.api.ApplicationServiceAPI;

import io.spring.guides.gs_producing_web_service.Respuesta;

@Scope("singleton")
@Service
public class ApplicationServiceImpl implements ApplicationServiceAPI{

	private GenerateJson generateJson=new GenerateJson();
	
	@Autowired
	ApplicationDaoAPI applicationDaoAPI;
	
	public Respuesta save(@Valid ApplicationObj application) {
		// TODO Auto-generated method stub
		if(application == null){
			throw new IllegalArgumentException("El parametro aplicacion es nulo");
		}
		
		return applicationDaoAPI.save(application);
	}

	public Respuesta edit(ApplicationObj application) {
		// TODO Auto-generated method stub
		if(application == null){
			throw new IllegalArgumentException("El parametro aplicacion es nulo");
		}
		
		return applicationDaoAPI.edit(application);
	}

	public Respuesta delete(Integer id) {
		// TODO Auto-generated method stub
		if(id == null){
			throw new IllegalArgumentException("El parametro es nulo");
		}
		return applicationDaoAPI.delete(id);
	}

	public Respuesta getById(Integer id) {
		if(id == null){
			throw new IllegalArgumentException("El parametro es nulo");
		}
		return applicationDaoAPI.getById(id);
	}

	public Respuesta getAll() {
		Respuesta respuesta = new Respuesta();
		ApiResponse resp= applicationDaoAPI.getAll();
		respuesta.setCodigo(resp.getCodigo());
		respuesta.setDescripcion(resp.getDescripcion());
		respuesta.setRespuesta(generateJson.respondeOBJSON(resp.getObjeto()));
		return respuesta;
	}

}
