package com.linktic.microservicios.app.inventario.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.microservicios.app.inventario.entity.Inventario;
import com.linktic.microservicios.app.inventario.repository.InventarioRepository;

@Service
public class InventarioServiceImpl implements InventarioService {

	@Autowired
    private InventarioRepository repository;
	
	@Override
	public Optional<Inventario> obtenerPorProductoId(Integer productoId) {
		// TODO Auto-generated method stub
		return repository.findByProductoId(productoId);
	}

	@Override
    public Inventario actualizarCantidad(Integer productoId, Integer nuevaCantidad) {
        Optional<Inventario> oInventario = repository.findByProductoId(productoId);

        if (oInventario.isPresent()) {
            Inventario inventario = oInventario.get();
            inventario.setCantidad(nuevaCantidad);
            System.out.println("🔔 Inventario actualizado para producto ID " + productoId + ": nueva cantidad = " + nuevaCantidad);
            return repository.save(inventario);
        } else {
            // Si no existe el inventario, lo creamos
            Inventario nuevo = new Inventario();
            nuevo.setProductoId(productoId);
            nuevo.setCantidad(nuevaCantidad);
            System.out.println("📦 Nuevo inventario creado para producto ID " + productoId + ": cantidad = " + nuevaCantidad);
            return repository.save(nuevo);
        }
    }



}
