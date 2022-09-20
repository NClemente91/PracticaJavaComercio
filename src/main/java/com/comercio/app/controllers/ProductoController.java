package com.comercio.app.controllers;

import com.comercio.app.entities.Producto;
import com.comercio.app.services.IBaseService;
import com.comercio.app.services.impl.ProductoService;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductoController {
    private EntityManager em;
    private IBaseService<Producto> productoService;

    public ProductoController(EntityManager em) {
        this.em = em;
        this.productoService = new ProductoService(this.em);
    }

    public List<Producto> getProductos() throws Exception {
        return productoService.findAll();
    }

    public Producto getProductoById(Integer id){
        return productoService.findById(id);
    }

    public Producto createProducto(Producto producto)  {
        return productoService.insert(producto);
    }

    public Producto updateProducto(Integer id, Producto producto) {
        return productoService.update(id, producto);
    }

    public boolean deleteProducto(Integer id){
        return  productoService.delete(id);
    }
}
