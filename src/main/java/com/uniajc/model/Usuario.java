package com.uniajc.model;

public class Usuario implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1795047978855176231L;
	private String identificacion;
	private String nombre;
	private String correo;
	private String telefono;
	private String direccion;
	private int edad;
	public Usuario(String identificacion, String nombre, String correo, String telefono, String direccion, int edad) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.edad = edad;
	}
	public Usuario() {
		super();

	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
}
