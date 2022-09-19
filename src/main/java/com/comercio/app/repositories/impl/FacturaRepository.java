package com.comercio.app.repositories.impl;

import com.comercio.app.entities.Factura;
import com.comercio.app.repositories.IBaseRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class FacturaRepository implements IBaseRepository<Factura> {
    private EntityManager em;

    public FacturaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Factura> findAll() {
        return em.createQuery("SELECT c FROM Factura c", Factura.class).getResultList();
    }

    @Override
    public Factura findById(Integer id) {
        return em.find(Factura.class, id);
    }

    @Override
    public void insert(Factura factura) {
        em.persist(factura);
    }

    @Override
    public void update(Factura factura) {
        em.merge(factura);
    }

    @Override
    public void delete(Factura factura) {
        em.remove(factura);
    }
}