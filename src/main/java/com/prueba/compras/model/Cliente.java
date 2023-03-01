package com.prueba.compras.model;

import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idCliente;
	
	@Column(nullable = false, length = 50)
	private String nombre;
	
	private Boolean activo;
	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<ListaCompra> listaCompras = new TreeSet<ListaCompra>();

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setId(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
