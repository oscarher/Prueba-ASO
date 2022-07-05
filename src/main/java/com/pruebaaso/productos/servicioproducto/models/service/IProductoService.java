package com.pruebaaso.productos.servicioproducto.models.service;

import java.util.List;

import com.pruebaaso.productos.servicioproducto.models.entity.Producto;

public interface IProductoService {
    
    public List<Producto> findAll();

    public Producto findById(Long id);

    public Producto saveProducto(Producto producto);

    public String deleteProducto(Long id);
}
