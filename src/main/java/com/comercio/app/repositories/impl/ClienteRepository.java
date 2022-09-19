package com.comercio.app.repositories.impl;

import com.comercio.app.entities.Cliente;
import com.comercio.app.repositories.IBaseRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteRepository implements IBaseRepository<Cliente> {

    private EntityManager em;

    public ClienteRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Cliente> findAll() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    @Override
    public Cliente findById(Integer id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void insert(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        em.remove(cliente);
    }
}
