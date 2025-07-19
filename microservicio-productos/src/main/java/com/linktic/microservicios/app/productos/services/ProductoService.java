package com.linktic.microservicios.app.productos.services;

import java.util.Optional;

import com.linktic.microservicios.app.productos.entity.Producto;

public interface ProductoService {
	
	public Iterable<Producto> findAll();
	
	public Optional<Producto> findById(Long id);
	
	public Producto save(Producto producto);
	
	public void deleteById(Long id);
	

}
