package  com.uniajc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ApplicationObj implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3998986926068234543L;
	int id_app;
	@NotNull (message = "Name cannot be null")
	@NotBlank
	String nombre;
	@NotNull
	String password;
	String fase_estado;
	String estado;
	@NotNull 
	@Size(min=2, max=30)
	String notas;
	@NotNull
	String version;

	public ApplicationObj(){
		
	}
	
	public ApplicationObj(int id_app, String nombre, String password, String fase_estado, String estado, String notas,
			String version) {
		super();
		this.id_app = id_app;
		this.nombre = nombre;
		this.password = password;
		this.fase_estado = fase_estado;
		this.estado = estado;
		this.notas = notas;
		this.version = version;
	}

	public int getId_app() {
		return id_app;
	}

	public void setId_app(int id_app) {
		this.id_app = id_app;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFase_estado() {
		return fase_estado;
	}

	public void setFase_estado(String fase_estado) {
		this.fase_estado = fase_estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	

}
