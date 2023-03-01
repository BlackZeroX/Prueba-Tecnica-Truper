package com.prueba.compras.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.compras.model.ListaCompra;

@Repository
public interface ListaCompraCRUD extends CrudRepository<ListaCompra, Integer> {

	// Limitado a 1, en si pódria obtener una lista...
	@Query("SELECT LC FROM ListaCompra LC WHERE LC.nombre = ?1 LIMIT 1")
	ListaCompra consultarPorNombre(String nombreLista);

	@Query("SELECT LC FROM ListaCompra LC WHERE LC.cliente.idCliente = ?1")
	List<ListaCompra> consultarPorIdCliente(Integer idCliente);
}
