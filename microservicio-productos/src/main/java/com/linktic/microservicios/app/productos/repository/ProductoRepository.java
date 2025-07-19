package com.linktic.microservicios.app.productos.repository;

import org.springframework.data.repository.CrudRepository;

import com.linktic.microservicios.app.productos.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
