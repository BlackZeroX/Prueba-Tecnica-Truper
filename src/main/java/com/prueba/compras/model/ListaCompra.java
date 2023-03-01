package com.prueba.compras.model;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Lista_Compra")
public class ListaCompra {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idLista;

	@ManyToOne
	@JoinColumn(name = "idCliente", nullable = false)
	private Cliente cliente;

	@Column(nullable = false, length = 50)
	private String nombre;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUltimaActualizacion;
	
	private Boolean activo;
	
	@ManyToOne
	@JoinColumn(name = "idListaCompra")
	private Set<ListaCompraDetalle> listaCompraDetalle = new TreeSet<>();

	public Integer getIdLista() {
		return idLista;
	}

	public void setIdLista(Integer idLista) {
		this.idLista = idLista;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Set<ListaCompraDetalle> getListaCompraDetalle() {
		return listaCompraDetalle;
	}

	public void setListaCompraDetalle(Set<ListaCompraDetalle> listaCompraDetalle) {
		this.listaCompraDetalle = listaCompraDetalle;
	}

}
