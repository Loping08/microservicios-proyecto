package com.linktic.microservicios.app.productos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linktic.microservicios.app.productos.entity.Producto;
import com.linktic.microservicios.app.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Producto> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Producto> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional()
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return repository.save(producto);
	}

	@Override
	@Transactional()
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
