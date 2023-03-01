package com.prueba.compras.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.compras.model.ListaCompraDetalle;
import com.prueba.compras.model.ListaCompraDetallePK;

@Repository
public interface ListaCompraDetalleCRUD extends CrudRepository<ListaCompraDetalle, ListaCompraDetallePK> {

}
