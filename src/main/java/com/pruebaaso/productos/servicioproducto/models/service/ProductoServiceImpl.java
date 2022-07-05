package com.pruebaaso.productos.servicioproducto.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebaaso.productos.servicioproducto.models.dao.ProductoDAO;
import com.pruebaaso.productos.servicioproducto.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private ProductoDAO productoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>)productoDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto saveProducto(Producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    @Transactional
    public String deleteProducto(Long id) {
        productoDAO.deleteById(id);
        return "Producto Eliminado";
    }
    
}
