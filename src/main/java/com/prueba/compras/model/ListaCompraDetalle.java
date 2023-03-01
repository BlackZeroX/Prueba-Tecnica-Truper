package com.prueba.compras.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lista_Compra_Detalle")
public class ListaCompraDetalle {

	@Id
	private ListaCompraDetallePK id;

	@Column(name = "idListaCompra", nullable = false)
	@OneToMany(fetch = FetchType.LAZY)
	private ListaCompra listaCompra;

	@Column(name = "idProducto", nullable = false)
	@OneToMany(fetch = FetchType.LAZY)
	private Producto producto;

	private Integer cantidad;

	public ListaCompraDetallePK getId() {
		return id;
	}

	public void setId(ListaCompraDetallePK id) {
		this.id = id;
	}

	public ListaCompra getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(ListaCompra listaCompra) {
		this.listaCompra = listaCompra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
