package com.prueba.compras.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.compras.model.Producto;

@Repository
public interface ProductosCRUD extends CrudRepository<Producto, Integer> {

}
