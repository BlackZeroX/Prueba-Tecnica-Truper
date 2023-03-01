package com.prueba.compras.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.compras.model.Cliente;

@Repository
public interface ClienteCRUD extends CrudRepository<Cliente, Integer> {

}
