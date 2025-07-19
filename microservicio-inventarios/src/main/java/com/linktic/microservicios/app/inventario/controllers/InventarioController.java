package com.linktic.microservicios.app.inventario.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.linktic.microservicios.app.inventario.configuration.ProductoServiceConfig;
import com.linktic.microservicios.app.inventario.entity.Inventario;
import com.linktic.microservicios.app.inventario.services.InventarioService;

@RestController
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductoServiceConfig productoServiceConfig;

    // 🔍 Consultar cantidad disponible por producto ID
    @GetMapping("/producto/{productoId}")
    public ResponseEntity<?> obtenerInventario(@PathVariable Integer productoId) {
        Optional<Inventario> oInventario = inventarioService.obtenerPorProductoId(productoId);

        if (!oInventario.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                    "errors", List.of(
                        Map.of(
                            "status", "404",
                            "title", "Producto no encontrado en inventario",
                            "detail", "No se encontró inventario para el producto con ID " + productoId,
                            "code", "INVENTARIO_NOT_FOUND"
                        )
                    )
                )
            );
        }

        // Obtenemos la URL del microservicio productos desde la config
        //String url = "http://" + productoServiceConfig.getUrl()+"/" + productoId;
        String url = "http://microservicio-productos/" + productoId;
        ResponseEntity<?> responseProducto = restTemplate.getForEntity(url, Object.class);

        return ResponseEntity.ok().body(
            new Object() {
                public final Object producto = responseProducto.getBody();
                public final int cantidad = oInventario.get().getCantidad();
            }
        );
    }

    // ✏️ Actualizar la cantidad de inventario
    @PutMapping("/producto/{productoId}")
    public ResponseEntity<?> actualizarCantidad(@PathVariable Integer productoId, @RequestParam Integer nuevaCantidad) {
        Inventario inventarioActualizado = inventarioService.actualizarCantidad(productoId, nuevaCantidad);
        return ResponseEntity.ok().body(inventarioActualizado);
    }
}
