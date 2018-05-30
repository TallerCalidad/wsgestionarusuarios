package com.uniajc.commons;

public class ApiResponse {
	private int codigo;
	private String descripcion;
	private Object objeto;
	public ApiResponse(int codigo, String descripcion, Object objeto) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.objeto = objeto;
	}
	public ApiResponse(int codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	public ApiResponse() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Object getObjeto() {
		return objeto;
	}
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	
}
