package com.linktic.microservicios.app.inventario.services;

import java.util.Optional;

import com.linktic.microservicios.app.inventario.entity.Inventario;

public interface InventarioService {
	
	Optional<Inventario> obtenerPorProductoId(Integer productoId);

	Inventario actualizarCantidad(Integer productoId, Integer nuevaCantidad);
}
