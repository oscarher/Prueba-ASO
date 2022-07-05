package com.pruebaaso.productos.servicioproducto.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.pruebaaso.productos.servicioproducto.models.entity.Producto;

public interface ProductoDAO extends CrudRepository<Producto, Long>{
    
}
