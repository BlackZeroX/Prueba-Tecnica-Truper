package com.prueba.compras.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class ListaCompraDetallePK {

	private Integer idListaCompra;
	private Integer idProducto;

	public Integer getIdListaCompra() {
		return idListaCompra;
	}

	public void setIdListaCompra(Integer idListaCompra) {
		this.idListaCompra = idListaCompra;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

}
