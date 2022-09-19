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
        try{
            return this.clienteRepository.findAll();
        }catch(Exception e){
           throw new Error(e.getMessage());
        }
    }

    @Override
    public Cliente findById(Integer id) {
        // Verificación
        try{
            return this.clienteRepository.findById(id);
        }catch(Exception e){
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Cliente insert(Cliente cliente) {
        try{
            this.clienteRepository.insert(cliente);
        }catch(Exception e){
            this.em.getTransaction().rollback();
            throw new Error(e.getMessage());
        }

        //Ver retorno del tipo Cliente
        return null;
    }

    @Override
    public Cliente update(Integer id, Cliente cliente) {
        try{
            this.clienteRepository.update(cliente);
        }catch(Exception e){
            this.em.getTransaction().rollback();
            throw new Error(e.getMessage());
        }

        //Ver retorno del tipo Cliente
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        // Verificación
        Cliente cliente = findById(id);

        try{
            this.clienteRepository.delete(cliente);
        }catch(Exception e){
            em.getTransaction().rollback();
            throw new Error(e.getMessage());
        }

        //Ver retorno del tipo Cliente
        return false;
    }


}
