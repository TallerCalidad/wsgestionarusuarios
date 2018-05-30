package  com.uniajc.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.uniajc.facade.api.ApplicationFacadeAPI;
import com.uniajc.model.ApplicationObj;

import io.spring.guides.gs_producing_web_service.CreateApplicationRequest;
import io.spring.guides.gs_producing_web_service.CreateApplicationResponse;
import io.spring.guides.gs_producing_web_service.DeleteDataApplicationRequest;
import io.spring.guides.gs_producing_web_service.DeleteDataApplicationResponse;
import io.spring.guides.gs_producing_web_service.GetAllDataApplicationRequest;
import io.spring.guides.gs_producing_web_service.GetAllDataApplicationResponse;
import io.spring.guides.gs_producing_web_service.GetDataApplicationRequest;
import io.spring.guides.gs_producing_web_service.GetDataApplicationResponse;
import io.spring.guides.gs_producing_web_service.Respuesta;
import io.spring.guides.gs_producing_web_service.UpdateApplicationRequest;
import io.spring.guides.gs_producing_web_service.UpdateApplicationResponse;

@Endpoint
//@ComponentScan("com.uniajc")
public class ApplicationEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	@Autowired
	ApplicationFacadeAPI applicationFacadeAPI;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetDataApplicationRequest")
	public @ResponsePayload GetDataApplicationResponse getDataApplication(@RequestPayload GetDataApplicationRequest request)
	{
		GetDataApplicationResponse response = new GetDataApplicationResponse();
		response.setRespuesta(applicationFacadeAPI.getById(request.getIdApp()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllDataApplicationRequest")
	public @ResponsePayload GetAllDataApplicationResponse getAllDataApplication(@RequestPayload GetAllDataApplicationRequest request)
	{
		GetAllDataApplicationResponse response = new GetAllDataApplicationResponse();
		response.setRespuesta(applicationFacadeAPI.getAll());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateApplicationRequest")
	public @ResponsePayload CreateApplicationResponse createApplication(@RequestPayload CreateApplicationRequest request)
	{
		CreateApplicationResponse response = new CreateApplicationResponse();
		// call Spring injected service implementation to retrieve account data 
		
		ApplicationObj applicationObj = new ApplicationObj();
		applicationObj.setEstado(request.getApplicationobj().getEstado());
		applicationObj.setFase_estado(request.getApplicationobj().getFaseEstado());
		applicationObj.setNombre(request.getApplicationobj().getNombre());
		applicationObj.setNotas(request.getApplicationobj().getNotas());
		applicationObj.setPassword(request.getApplicationobj().getPassword());
		applicationObj.setVersion(request.getApplicationobj().getVersion());
		
		Respuesta respuesta = new Respuesta();
		respuesta.setCodigo(1);
		respuesta.setDescripcion("Exito");
		applicationFacadeAPI.save(applicationObj);
		respuesta.setRespuesta("");
		response.setRespuesta(respuesta);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateApplicationRequest")
	public @ResponsePayload UpdateApplicationResponse updateApplication(@RequestPayload UpdateApplicationRequest request)
	{
		UpdateApplicationResponse response = new UpdateApplicationResponse();
		// call Spring injected service implementation to retrieve account data 
		ApplicationObj applicationObj = new ApplicationObj();
		applicationObj.setId_app(request.getApplicationobj().getIdApp());
		applicationObj.setEstado(request.getApplicationobj().getEstado());
		applicationObj.setFase_estado(request.getApplicationobj().getFaseEstado());
		applicationObj.setNombre(request.getApplicationobj().getNombre());
		applicationObj.setNotas(request.getApplicationobj().getNotas());
		applicationObj.setPassword(request.getApplicationobj().getPassword());
		applicationObj.setVersion(request.getApplicationobj().getVersion());
		
		Respuesta respuesta = new Respuesta();
		respuesta.setCodigo(1);
		respuesta.setDescripcion("Exito");
		applicationFacadeAPI.edit(applicationObj);
		respuesta.setRespuesta("");
		response.setRespuesta(respuesta);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteDataApplicationRequest")
	public @ResponsePayload DeleteDataApplicationResponse deleteDataApplication(@RequestPayload DeleteDataApplicationRequest request)
	{
		DeleteDataApplicationResponse response = new DeleteDataApplicationResponse();
		// call Spring injected service implementation to retrieve account data 
		Respuesta respuesta = new Respuesta();
		respuesta.setCodigo(1);
		respuesta.setDescripcion("Exito");
		applicationFacadeAPI.delete(request.getIdApp());
		respuesta.setRespuesta("");
		response.setRespuesta(respuesta);
		return response;
	}
	
	
	
}