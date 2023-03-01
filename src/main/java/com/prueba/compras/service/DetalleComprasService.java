package com.prueba.compras.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.compras.controller.model.CompraRequest;
import com.prueba.compras.model.Cliente;
import com.prueba.compras.model.ListaCompra;
import com.prueba.compras.model.ListaCompraDetalle;
import com.prueba.compras.model.Producto;
import com.prueba.compras.model.dao.ListaCompraCRUD;
import com.prueba.compras.model.dao.ListaCompraDetalleCRUD;
import com.prueba.compras.service.exceptions.ListaCompraNoFoundException;

@Service
public class DetalleComprasService {

	@Autowired
	private ListaCompraCRUD listaCompraCRUD;
	
	@Autowired
	private ListaCompraDetalleCRUD listaCompraDetalleCRUD;
	
	
	@Transactional
	public void crearCompra(
		Integer idCliente,
		String nombreLista,
		List<CompraRequest> request
	) throws ListaCompraNoFoundException {
		ListaCompra listaCompra = listaCompraCRUD.consultarPorNombre(nombreLista);
		
		if (listaCompra == null) {
			throw new ListaCompraNoFoundException(nombreLista);
		}
		
		crearDetalleCompra(idCliente, request, listaCompra);
	}
	
	@Transactional(readOnly = true)
	public List<ListaCompra> obtenerDetalleCompras(
		Integer idCliente
	) {
		return listaCompraCRUD.consultarPorIdCliente(idCliente);
	}
	
	@Transactional
	public void actualizarNombreLista(
		Integer idCliente,
		String nombreLista,
		List<CompraRequest> request,
		String nombreListaNew,
		List<CompraRequest> requestNew
	) throws ListaCompraNoFoundException {
		ListaCompra listaCompra = listaCompraCRUD.consultarPorNombre(nombreLista);
		
		if (listaCompra == null) {
			throw new ListaCompraNoFoundException(nombreLista);
		}
		
		if (nombreListaNew != null) {
			listaCompra.setNombre(nombreListaNew);
			listaCompraCRUD.save(listaCompra);
		}
		
		crearDetalleCompra(idCliente, request, listaCompra);
	}
	
	// No indica el criterio en el ejercicio de eliminacion asi que se apsa solo el Id del cliente.
	@Transactional
	public void eliminarDetalleCompras(
		Integer idCliente
	) {
		List<ListaCompra> lstCompras = obtenerDetalleCompras(idCliente);
		lstCompras.forEach(item -> listaCompraCRUD.delete(item));
	}
	
	private void crearDetalleCompra(Integer idCliente, List<CompraRequest> request, ListaCompra listaCompra) {
		ListaCompra compra = new ListaCompra();
		Cliente cliente = new Cliente();
		// TODO Faltaria validar existencia del cliente.
		cliente.setId(idCliente);
		
		compra.setCliente(cliente);
		
		request.forEach(item -> {
			Producto producto = new Producto();
			// TODO Faltaria validar producto.
			producto.setIdProducto(item.getIdProducto());
			
			ListaCompraDetalle itemDetalleCompra = new ListaCompraDetalle();
			// No es necesqario setear el ID con las entidades que contengan los ID.
			// itemDetalleCompra.setId(?)
			itemDetalleCompra.setCantidad(item.getCantidad());
			itemDetalleCompra.setProducto(producto);
			itemDetalleCompra.setListaCompra(listaCompra);
			
			// El metodo save sirve para crear/actualizar
			listaCompraDetalleCRUD.save(itemDetalleCompra);
		});
	}
}
