package com.pruebaaso.productos.servicioproducto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaaso.productos.servicioproducto.models.entity.Producto;
import com.pruebaaso.productos.servicioproducto.models.service.IProductoService;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> listAll() {
        return productoService.findAll();
    }

    @GetMapping("/ver/{id}")
    public Producto findProduct(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping("/guardar")
    public Producto saveProducto (@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @PutMapping("/editar/{id}")
    public Producto editarProducto (@RequestBody Producto producto, @PathVariable Long id) {
        Producto productoDB = productoService.findById(id);

        productoDB.setName(producto.getName());
        productoDB.setPrice(producto.getPrice());

        return productoService.saveProducto(productoDB);
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteProducto (@PathVariable Long id) {
        return productoService.deleteProducto(id);
    }
}
