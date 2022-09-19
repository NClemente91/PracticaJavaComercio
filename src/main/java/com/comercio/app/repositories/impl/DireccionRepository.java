package com.comercio.app.repositories.impl;

import com.comercio.app.entities.Direccion;
import com.comercio.app.repositories.IBaseRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DireccionRepository implements IBaseRepository<Direccion> {
    private EntityManager em;

    public DireccionRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Direccion> findAll() {
        return em.createQuery("SELECT c FROM Direccion c", Direccion.class).getResultList();
    }

    @Override
    public Direccion findById(Integer id) {
        return em.find(Direccion.class, id);
    }

    @Override
    public void insert(Direccion direccion) {
        em.persist(direccion);
    }

    @Override
    public void update(Direccion direccion) {
        em.merge(direccion);
    }

    @Override
    public void delete(Direccion direccion) {
        em.remove(direccion);
    }
}