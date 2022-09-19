package com.comercio.app.repositories.impl;

import com.comercio.app.entities.Producto;
import com.comercio.app.repositories.IBaseRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductoRepository implements IBaseRepository<Producto> {
    private EntityManager em;

    public ProductoRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Producto> findAll() {
        return em.createQuery("SELECT c FROM Producto c", Producto.class).getResultList();
    }

    @Override
    public Producto findById(Integer id) {
        return em.find(Producto.class, id);
    }

    @Override
    public void insert(Producto producto) {
        em.persist(producto);
    }

    @Override
    public void update(Producto producto) {
        em.merge(producto);
    }

    @Override
    public void delete(Producto producto) {
        em.remove(producto);
    }
}
