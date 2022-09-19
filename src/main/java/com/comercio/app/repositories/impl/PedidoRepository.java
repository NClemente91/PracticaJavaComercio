package com.comercio.app.repositories.impl;

import com.comercio.app.entities.Pedido;
import com.comercio.app.repositories.IBaseRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PedidoRepository implements IBaseRepository<Pedido> {
    private EntityManager em;

    public PedidoRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Pedido> findAll() {
        return em.createQuery("SELECT c FROM Pedido c", Pedido.class).getResultList();
    }

    @Override
    public Pedido findById(Integer id) {
        return em.find(Pedido.class, id);
    }

    @Override
    public void insert(Pedido pedido) {
        em.persist(pedido);
    }

    @Override
    public void update(Pedido pedido) {
        em.merge(pedido);
    }

    @Override
    public void delete(Pedido pedido) {
        em.remove(pedido);
    }
}