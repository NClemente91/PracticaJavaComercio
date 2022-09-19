package com.comercio.app.services.impl;

import com.comercio.app.entities.Cliente;
import com.comercio.app.repositories.IBaseRepository;
import com.comercio.app.services.IBaseService;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteService implements IBaseService<Cliente> {

    private EntityManager em;
    private IBaseRepository<Cliente> clienteRepository;

    public ClienteService(EntityManager em, IBaseRepository<Cliente> clienteRepository) {
        this.em = em;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return null;
    }

    @Override
    public Cliente insert(Cliente entity) {
        return null;
    }

    @Override
    public Cliente update(Long id, Cliente entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
