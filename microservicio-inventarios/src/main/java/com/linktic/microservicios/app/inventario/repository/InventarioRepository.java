package com.linktic.microservicios.app.inventario.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.linktic.microservicios.app.inventario.entity.Inventario;

public interface InventarioRepository extends CrudRepository<Inventario, Long> {
	
	Optional<Inventario> findByProductoId(Integer productoId);

}
