package com.prueba.compras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prueba.compras.controller.model.CompraRequest;
import com.prueba.compras.model.ListaCompra;
import com.prueba.compras.service.DetalleComprasService;
import com.prueba.compras.service.exceptions.ListaCompraNoFoundException;

@Controller
@RequestMapping("carrito-compras")
public class CarritoDeComprasController {

	@Autowired
	private DetalleComprasService service;

	@PostMapping
	@RequestMapping("/{cliente}/{nombreLista}")
	public void crearCompra(@PathVariable(name = "cliente", required = true) Integer idCliente,
			@PathVariable(name = "nombreLista", required = true) String nombreLista,
			@RequestBody List<CompraRequest> request) {
		try {
			service.crearCompra(idCliente, nombreLista, request);
		} catch (ListaCompraNoFoundException e) {
			// TODO Faltaria Enviar un codigo de error, parte fea aqui o con un transformador.
		}
	}

	@GetMapping
	@ResponseBody
	@RequestMapping("/{cliente}")
	public List<ListaCompra> obtenerCompras(@PathVariable(name = "cliente", required = true) Integer idCliente,
			@RequestBody List<CompraRequest> request) {
		return service.obtenerDetalleCompras(idCliente);
	}

	/**
	 * Actualiza la lista de compras de un cliente
	 * 
	 * @param idCliente
	 * @param nombreLista
	 * @param nombreListaNew
	 * @param request
	 */
	@PutMapping
	@RequestMapping("/{cliente}/{nombreLista}/to/{nombreListaNew}")
	public void actualizarCompras(@PathVariable(name = "cliente", required = true) Integer idCliente,
			@PathVariable(name = "nombreLista", required = true) String nombreLista,
			@PathVariable(name = "nombreListaNew", required = false) String nombreListaNew,
			@RequestBody List<CompraRequest> request) {
		try {
			service.actualizarNombreLista(idCliente, nombreLista, request, nombreListaNew, request);
		} catch (ListaCompraNoFoundException e) {
			// TODO Faltaria Enviar un codigo de error, parte fea aqui o con un transformador.
		}
	}

	/**
	 * Elimina la lista de compras (Todas) de un cliente.
	 * 
	 * @param idCliente
	 * @param request
	 */
	@DeleteMapping
	@RequestMapping("/{cliente}")
	public void eliminarCompras(@PathVariable(name = "cliente", required = true) Integer idCliente,
			@RequestBody List<CompraRequest> request) {
		service.eliminarDetalleCompras(idCliente);
	}

}
