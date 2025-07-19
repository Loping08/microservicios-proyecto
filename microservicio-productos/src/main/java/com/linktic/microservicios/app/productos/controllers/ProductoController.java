package com.linktic.microservicios.app.productos.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.linktic.microservicios.app.productos.entity.Producto;
import com.linktic.microservicios.app.productos.services.ProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
		Optional<Producto> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Producto p) {
		Producto productoDB = service.save(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoDB);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Producto producto, @PathVariable Long id) {
		Optional<Producto> o = this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
		}
		Producto productoDB = o.get();
		if (producto.getNombre() != null)
			productoDB.setNombre(producto.getNombre());
	    if (producto.getPrecio() != null) 
	        productoDB.setPrecio(producto.getPrecio());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(productoDB));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		Optional<Producto> a = service.findById(id);

		if (!a.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
