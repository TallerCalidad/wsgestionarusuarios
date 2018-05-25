package  com.uniajc.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.uniajc.facade.api.UserFacadeApi;

import co.edu.uniajc.users.web_service.CreateUserRequest;
import co.edu.uniajc.users.web_service.CreateUserResponse;
import co.edu.uniajc.users.web_service.DeleteUserRequest;
import co.edu.uniajc.users.web_service.DeleteUserResponse;
import co.edu.uniajc.users.web_service.GetAllUserRequest;
import co.edu.uniajc.users.web_service.GetAllUserResponse;
import co.edu.uniajc.users.web_service.GetUserRequest;
import co.edu.uniajc.users.web_service.GetUserResponse;
import co.edu.uniajc.users.web_service.UpdateUserRequest;
import co.edu.uniajc.users.web_service.UpdateUserResponse;

@Endpoint
public class UsuarioEndpoint {
	private static final String NAMESPACE_URI = "http://uniajc.edu.co/users/web-service";
	
	@Autowired
	UserFacadeApi userFacadeApi;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserRequest")
	public @ResponsePayload GetUserResponse getUser(@RequestPayload GetUserRequest request)
	{
		GetUserResponse response = new GetUserResponse();
		response.setRespuesta(userFacadeApi.getUser(request.getIdentificacion()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart ="GetAllUserRequest")
	public @ResponsePayload GetAllUserResponse getAllUser(@RequestPayload GetAllUserRequest request)
	{
		GetAllUserResponse response = new GetAllUserResponse();
		response.setRespuesta(userFacadeApi.getAllUser());
		return response;
	}
	
	
	@PayloadRoot(namespace= NAMESPACE_URI, localPart="CreateUserRequest")
	public @ResponsePayload CreateUserResponse createUser(@RequestPayload CreateUserRequest request)
	{
		CreateUserResponse response = new CreateUserResponse();
		
		response.setRespuesta(userFacadeApi.createUser(request.getUsuario()));
		return response;
	}
	
	@PayloadRoot(namespace= NAMESPACE_URI,localPart="DeleteUserRequest")
	public @ResponsePayload DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request)
	{
		DeleteUserResponse response = new DeleteUserResponse();
		response.setRespuesta(userFacadeApi.deleteUser(request.getIdentificacion()));
		return response;
	}
	
	
}