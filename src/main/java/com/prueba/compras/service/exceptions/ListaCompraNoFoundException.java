package com.prueba.compras.service.exceptions;

public class ListaCompraNoFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -875999084844045646L;

	private String nombreLista;

	public ListaCompraNoFoundException(String nombreLista) {
		super();
		this.nombreLista = nombreLista;
	}

	public String getNombreLista() {
		return nombreLista;
	}

	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}

}
