package com.prueba.compras.controller.model;

import java.io.Serializable;

public class CompraRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7783814129600328638L;

	private Integer idProducto;
	private Integer cantidad;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
